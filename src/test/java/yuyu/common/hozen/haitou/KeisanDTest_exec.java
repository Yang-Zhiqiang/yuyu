package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetDrate;
import yuyu.common.biz.bzcommon.BzGetDrateMockForHozen;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * KeisanDクラスのメソッド {@link KeisanD#exec(KeisanDBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当金計算";

    private final static String sheetName = "INデータ_20201211";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzGetDrate.class).to(BzGetDrateMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanDTest_exec.class, fileName, sheetName);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {

        BzGetDrateMockForHozen.caller = KeisanDTest_exec.class;
        KeisanGaikakanzanMockForHozen.caller = KeisanDTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateD());
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(1000)
    @Transactional
    public void testExec_A1_B6_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ008", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(1010)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exStringEquals((String) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 0), "ﾕｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(10), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 3),
            C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 4),
            C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 5), 30, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 6),
            C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 7), 10, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 8), 5, "払込期間");
        exStringEquals((String) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 9), "2018", "Ｄ年度");
        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exClassificationEquals((C_DRateGetKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 11),
            C_DRateGetKbn.ALL, "Ｄレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 12), 0, "経過年数");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(1020)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(2), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(3), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(4), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(5), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(6), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(80), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(10), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(10), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(10), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(10), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(10), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(10), "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1030)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2019));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), null, "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1040)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1), "金額");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(10), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1050)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1), "金額");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(10), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1060)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2015));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1), "金額");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(10), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1070)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1), "金額");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(10), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1080)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2014));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(1090)
    public void testExec_A9() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2014));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(2), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(3), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(4), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(5), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(6), "配当金（危険Sレート使用）");

    }

    @Test
    @TestOrder(2010)
    public void testExec_B1() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(2020)
    public void testExec_B2() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(2030)
    public void testExec_B3() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN5;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(2040)
    public void testExec_B4() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN6;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(2050)
    public void testExec_B5() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN7;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(2060)
    public void testExec_B6() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = BzGetDrateMockForHozen.TESTPATTERN8;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_NaiteiKakuteiKbn) MockObjectManager.getArgument(BzGetDrateMockForHozen.class, "exec", 0, 10),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(2585), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(163246), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(162490), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(0), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(2206), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3000)
    @Transactional
    public void testExec_C1_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3010)
    public void testExec_C1() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(2699), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3020)
    @Transactional
    public void testExec_C2_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3021)
    public void testExec_C2() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｶ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.027));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(40);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(76543.21, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(32.91, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(121.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3993), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3030)
    @Transactional
    public void testExec_C3_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3031)
    public void testExec_C3() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.FEMALE);
        getDRateSyutokuInfoBean.setHhknnen(62);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2018));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(2);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1632.46, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(88.88), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(145094), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3040)
    @Transactional
    public void testExec_C4_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3041)
    public void testExec_C4() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｶ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.027));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.FEMALE);
        getDRateSyutokuInfoBean.setHhknnen(40);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2019));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(76543.21, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(2);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(56.64, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(60.646), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3435), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3050)
    @Transactional
    public void testExec_C5_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3051)
    public void testExec_C5() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(40);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2019));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(12345.67, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(60.646), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(3060)
    @Transactional
    public void testExec_C6_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(3061)
    public void testExec_C6() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｶ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.027));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.FEMALE);
        getDRateSyutokuInfoBean.setHhknnen(80);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(76543.21, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(59.646), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(4010)
    public void testExec_D1() {

        MockObjectManager.initialize();
        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｹ");
        getDRateSyutokuInfoBean.setRyouritusdno("101");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(10));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(30);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(10);
        getDRateSyutokuInfoBean.setHrkkkn(5);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2014));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(1));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean);
        haitouKaisuuBean.setHaitoukaisuu(1);
        haitouKaisuuBean.setKeikamon(12);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);

    }

    @Test
    @TestOrder(5010)
    @Transactional
    public void testExec_E01_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(5010)
    public void testExec_E01() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｹ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(0), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(0), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().size(), 0);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5020)
    public void testExec_E02() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｹ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5030)
    public void testExec_E03() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕB");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(6);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(7);
        haitouKaisuuBean2.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(0), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(0), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().size(), 0);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5040)
    public void testExec_E04() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾁ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5050)
    public void testExec_E05() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2019));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(2699), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(2699), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(33550), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getdrate(),  BizNumber.valueOf(0.00435), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(33550), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20190329), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5060)
    public void testExec_E06() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.006));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), null, "配当金");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), null);
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo1(), "為替レート取得エラー", "エラー情報（大分類）");
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo2(), "", "エラー情報（小分類）");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(5070)
    public void testExec_E07() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｲ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.AUD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(79153.81, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setHaitoukaisuu(3);
        haitouKaisuuBean1.setKeikamon(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(29.28, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(141.57), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(345), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(79153.81, BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00037), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(141.57), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 1);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(29.28, BizCurrencyTypes.AU_DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(345), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(5080)
    public void testExec_E08() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｲ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.006));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.AUD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2017));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), null, "配当金");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), null);
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo1(), "為替レート取得エラー", "エラー情報（大分類）");
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo2(), "", "エラー情報（小分類）");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(5090)
    public void testExec_E09() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕA");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(100);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(-15407), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(-0.00234), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(-15407), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5100)
    public void testExec_E10() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕA");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.006));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), null, "配当金");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), null);
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo1(), "Ｄレート取得エラー", "エラー情報（大分類）");
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo2(), "", "エラー情報（小分類）");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(5110)
    public void testExec_E11() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.004));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(8618.05, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), null, "配当金");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), null);
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo1(), "Ｄレート取得エラー", "エラー情報（大分類）");
        exStringEquals(keisanD.getErrorInfo().get(0).getErrorInfo2(), "", "エラー情報（小分類）");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(5120)
    public void testExec_E12() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(2);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00036), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5130)
    public void testExec_E13() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(4);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(12);
        haitouKaisuuBean2.setHaitoukaisuu(5);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(4377), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00038), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00039), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(4377), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5140)
    public void testExec_E14() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(6);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(7);
        haitouKaisuuBean2.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3425), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00040), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.6, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1407), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00041), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(28.29, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(2018), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5150)
    public void testExec_E15() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(8);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(6);
        haitouKaisuuBean2.setHaitoukaisuu(9);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3278), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00042), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1620), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00043), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(1658), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5160)
    public void testExec_E16() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(6);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(7);
        haitouKaisuuBean2.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3425), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00040), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.6, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1407), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00041), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(28.29, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(2018), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5170)
    public void testExec_E17() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(4);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(12);
        haitouKaisuuBean2.setHaitoukaisuu(5);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(4377), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00038), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00039), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(4377), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5180)
    public void testExec_E18() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(8);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(6);
        haitouKaisuuBean2.setHaitoukaisuu(9);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3278), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00042), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1620), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00043), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(1658), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5190)
    public void testExec_E19() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(2699), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(2699), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(33550), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getdrate(),  BizNumber.valueOf(0.00435), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(33550), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5200)
    public void testExec_E20() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(100);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(-15407), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(-0.00234), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(-15407), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5210)
    public void testExec_E21() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(2);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00036), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5220)
    public void testExec_E22() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾊ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.AUD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(79153.81, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setHaitoukaisuu(3);
        haitouKaisuuBean1.setKeikamon(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(29.28, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(141.57), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(345), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(79153.81, BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00037), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(141.57), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 1);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(29.28, BizCurrencyTypes.AU_DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(345), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(5230)
    public void testExec_E23() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾍ");
        getDRateSyutokuInfoBean.setRyouritusdno("L");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2021));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5240)
    public void testExec_E24() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾍ");
        getDRateSyutokuInfoBean.setRyouritusdno("L");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(0);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2021));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(0), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(0), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(), null, "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().size(), 0);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().size(), 0);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5250)
    public void testExec_E25() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.ARI);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
            BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(2699), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), BizCurrency.valueOf(0), "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), BizCurrency.valueOf(2699), "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), BizCurrency.valueOf(0), "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), BizCurrency.valueOf(33550), "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), BizCurrency.valueOf(0), "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanSisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanRisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(2699), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanHisaDrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getdrate(),  BizNumber.valueOf(0.00435), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(274.28, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanDyouVrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(33550), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getdrate(),  BizNumber.valueOf(0), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanKikenSrateList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5260)
    public void testExec_E26() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(12);
        haitouKaisuuBean1.setHaitoukaisuu(100);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(-15407), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6584327, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(-0.00234), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(-15407), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5270)
    public void testExec_E27() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(2);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(55002.42, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00036), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(19.80, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5280)
    public void testExec_E28() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(79153.81, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setHaitoukaisuu(3);
        haitouKaisuuBean1.setKeikamon(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(29.28, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(298), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(79153.81, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00037), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 1);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(29.28, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(298), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(5290)
    public void testExec_E29() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(6);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(7);
        haitouKaisuuBean2.setHaitoukaisuu(7);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3425), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00040), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.6, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1407), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(69022.37, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00041), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(28.29, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(2018), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5300)
    public void testExec_E30() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(0);
        haitouKaisuuBean1.setHaitoukaisuu(4);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(12);
        haitouKaisuuBean2.setHaitoukaisuu(5);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(4377), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00038), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 0);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(34.86, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(0), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(91758.01, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00039), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 12);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(35.78, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(4377), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(5310)
    public void testExec_E31() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(8);
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean2);
        haitouKaisuuBean2.setKeikamon(6);
        haitouKaisuuBean2.setHaitoukaisuu(9);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(122.32), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(3278), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00042), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(26.48, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1620), "配当金（円貨）");

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getdrate(),  BizNumber.valueOf(0.00043), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getKawaserate(), BizNumber.valueOf(122.32), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(1).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYenKansanMae(), BizCurrency.valueOf(27.11, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(1).getHaitoukinYen(), BizCurrency.valueOf(1658), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6000)
    @Transactional
    public void testExec_F1_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(6010)
    public void testExec_F1() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1570), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1570), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6020)
    public void testExec_F2() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.AUD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63005.12, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.05, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.01), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1121), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63005.12, BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.01), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.05, BizCurrencyTypes.AU_DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1121), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(6030)
    public void testExec_F3() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(9);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1654), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 9);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1654), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6040)
    public void testExec_F4() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(21.00, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1281), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1281), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6050)
    public void testExec_F5() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1570), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1570), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6060)
    public void testExec_F6() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.AUD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.AUD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63005.12, BizCurrencyTypes.AU_DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(5);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.05, BizCurrencyTypes.AU_DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.01), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1121), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63005.12, BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.01), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 5);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.05, BizCurrencyTypes.AU_DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1121), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(6070)
    public void testExec_F7() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(9);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1654), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 9);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1654), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6080)
    public void testExec_F8() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾕﾉ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(2);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(21.00, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1281), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1281), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6090)
    public void testExec_F9() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(7);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1570), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(63053.98, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 7);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(22.06, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1570), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6100)
    public void testExec_F10() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanDBean.setKihonS(BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(9);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1654), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(6305398, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), null, "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), null, "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 9);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), null, "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1654), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(6110)
    public void testExec_F11() {

        MockObjectManager.initialize();

        BzGetDrateMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        KeisanD keisanD = SWAKInjector.getInstance(KeisanD.class);
        KeisanDBean keisanDBean = new KeisanDBean();
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);

        DRateSyutokuInfoBean getDRateSyutokuInfoBean = setDNnd.new DRateSyutokuInfoBean();
        keisanDBean.setDRateSyutokuInfoBean(getDRateSyutokuInfoBean);
        getDRateSyutokuInfoBean.setSyouhncd("ﾆｱ");
        getDRateSyutokuInfoBean.setRyouritusdno("J");
        getDRateSyutokuInfoBean.setYoteiriritu(BizNumber.valueOf(0.005));
        getDRateSyutokuInfoBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        getDRateSyutokuInfoBean.setHhknsei(C_Hhknsei.MALE);
        getDRateSyutokuInfoBean.setHhknnen(84);
        getDRateSyutokuInfoBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        getDRateSyutokuInfoBean.setHknkkn(99);
        getDRateSyutokuInfoBean.setHrkkkn(0);
        getDRateSyutokuInfoBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        getDRateSyutokuInfoBean.setTuukasyu(C_Tuukasyu.USD);
        getDRateSyutokuInfoBean.setDai1hknkkn(5);
        getDRateSyutokuInfoBean.setDratenendo(BizDateY.valueOf(2016));
        getDRateSyutokuInfoBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        keisanDBean.setTuukasyu(C_Tuukasyu.USD);
        keisanDBean.setKihonS(BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR));
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);

        List<HaitouKaisuuBean> haitouKaisuuBeanList = new ArrayList<>();
        keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanList);
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        haitouKaisuuBeanList.add(haitouKaisuuBean1);
        haitouKaisuuBean1.setKeikamon(6);
        haitouKaisuuBean1.setHaitoukaisuu(1);

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(21.00, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(122.00), "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exBizCalcbleEquals(keisanD.getD(), BizCurrency.valueOf(1281), "配当金");
        exBizCalcbleEquals(keisanD.getDSisaDrate(), null, "配当金（死差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDRisaDrate(), null, "配当金（利差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDHisaDrate(), null, "配当金（費差Ｄレート使用）");
        exBizCalcbleEquals(keisanD.getDDyouVrate(), null, "配当金（Ｄ用Vレート使用）");
        exBizCalcbleEquals(keisanD.getDKikenSrate(), null, "配当金（危険Sレート使用）");
        assertEquals(keisanD.getDRateSyutokuInfoBean(), getDRateSyutokuInfoBean);

        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKihonS(), BizCurrency.valueOf(60000.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getdrate(),  BizNumber.valueOf(0.00035), "Ｄレート");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getKawaserate(), BizNumber.valueOf(122.00), "為替レート");
        exDateEquals(keisanD.getKeisanDInfoBeanList().get(0).getKwsratekjymd(), BizDate.valueOf(20160331), "為替レート基準日");
        assertEquals(keisanD.getKeisanDInfoBeanList().get(0).getKeikaTukisuu(), 6);
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYenKansanMae(), BizCurrency.valueOf(21, BizCurrencyTypes.DOLLAR), "配当金（円換算前）");
        exBizCalcbleEquals(keisanD.getKeisanDInfoBeanList().get(0).getHaitoukinYen(), BizCurrency.valueOf(1281), "配当金（円貨）");

        assertEquals(keisanD.getKeisanDInfoBeanSisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanRisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanHisaDrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanDyouVrateList(), null);
        assertEquals(keisanD.getKeisanDInfoBeanKikenSrateList(), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

}