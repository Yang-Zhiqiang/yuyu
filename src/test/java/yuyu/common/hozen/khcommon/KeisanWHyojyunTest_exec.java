package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

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

import yuyu.common.biz.bzcommon.BzGetWrate;
import yuyu.common.biz.bzcommon.BzGetWrateMockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_WRateGetKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 標準解約返戻金計算のメソッド {@link KeisanWHyojyun#exec(BizDate, BizDateYM, KeisanWExtBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWHyojyunTest_exec {

    @Inject
    private KeisanWHyojyun keisanWHyojyun;

    private static final String PARAMETER_NENMANKI = "年満期データ";

    private static final String PARAMETER_SAIMANKI = "歳満期データ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetWrate.class).to(BzGetWrateMockForHozen.class);
                bind(KeisanV.class).to(KeisanVMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        BzGetWrateMockForHozen.caller = KeisanWHyojyunTest_exec.class;
        KeisanVMockForHozen.caller = KeisanWHyojyunTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetWrateMockForHozen.caller = null;
        BzGetWrateMockForHozen.SYORIPTN = null;
        KeisanVMockForHozen.caller = null;
        KeisanVMockForHozen.SYORIPTN = null;
    }

    private KeisanWExtBean createKeisanWExtBean(String pParameterPattern) {

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        if (PARAMETER_NENMANKI.equals(pParameterPattern)) {
            keisanWExtBean.setSyouhncd("ﾆｱ");
            keisanWExtBean.setSyouhnsdno(1);
            keisanWExtBean.setRyouritusdno("L");
            keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.0025));
            keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
            keisanWExtBean.setHknkkn(10);
            keisanWExtBean.setHrkkkn(5);
            keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
            keisanWExtBean.setHhknnen(40);
            keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
            keisanWExtBean.setKihons(BizCurrency.valueOf(5005.00, BizCurrencyTypes.DOLLAR));
            keisanWExtBean.setHokenryou(BizCurrency.valueOf(50.03, BizCurrencyTypes.DOLLAR));
            keisanWExtBean.setKykymd(BizDate.valueOf(20200229));
            keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
            keisanWExtBean.setDai1hknkkn(5);
            keisanWExtBean.setKykJyoutai(C_Kykjyoutai.HARAIMAN);
        }
        else if(PARAMETER_SAIMANKI.equals(pParameterPattern)) {
            keisanWExtBean.setSyouhncd("ﾆｱ");
            keisanWExtBean.setSyouhnsdno(1);
            keisanWExtBean.setRyouritusdno("L");
            keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.0025));
            keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
            keisanWExtBean.setHknkkn(50);
            keisanWExtBean.setHrkkkn(45);
            keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
            keisanWExtBean.setHhknnen(40);
            keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
            keisanWExtBean.setKihons(BizCurrency.valueOf(5005.00, BizCurrencyTypes.DOLLAR));
            keisanWExtBean.setHokenryou(BizCurrency.valueOf(50.03, BizCurrencyTypes.DOLLAR));
            keisanWExtBean.setKykymd(BizDate.valueOf(20200229));
            keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
            keisanWExtBean.setDai1hknkkn(5);
            keisanWExtBean.setKykJyoutai(C_Kykjyoutai.HARAIMAN);
        }

        return keisanWExtBean;
    }

    private void checkErrorResult(C_ErrorKbn pResultKbn) {
        exClassificationEquals(pResultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWHyojyun.getW(), null, "解約返戻金");
        exNumericEquals(keisanWHyojyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHyojyun.getKeikatukisuu(), 0, "経過月数");
    }

    private void checkSuccessResult(C_ErrorKbn pResultKbn, BizCurrency pKaiyakuhr, int pKeikanensuu, int pKeikatukisuu) {
        exClassificationEquals(pResultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWHyojyun.getW(), pKaiyakuhr, "解約返戻金");
        exNumericEquals(keisanWHyojyun.getKeikanensuu(), pKeikanensuu, "経過年数");
        exNumericEquals(keisanWHyojyun.getKeikatukisuu(), pKeikatukisuu, "経過月数");
    }

    private void checkBzGetWrateParameter(KeisanWExtBean pKeisanWExtBean, C_Kykjyoutai pKykjyoutai, C_WRateGetKbn pWRateGetKbn, int pKeikaNensuu) {
        exStringEquals((String) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 0), pKeisanWExtBean.getSyouhncd(), "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 1), pKeisanWExtBean.getRyouritusdno(), "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 2), pKeisanWExtBean.getYoteiriritu(), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 3), pKeisanWExtBean.getHrkkaisuu(), "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 4), pKeisanWExtBean.getHhknsei(), "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 5), pKeisanWExtBean.getHhknnen(), "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 6), pKeisanWExtBean.getHknkknsmnkbn(), "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 7), pKeisanWExtBean.getHknkkn(), "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 8), pKeisanWExtBean.getHrkkkn(), "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 9), pKykjyoutai, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 10), pKeisanWExtBean.getTuukasyu(), "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 11), pKeisanWExtBean.getDai1hknkkn(), "第１保険期間");
        exClassificationEquals((C_WRateGetKbn) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 12), pWRateGetKbn, "Ｗレート取得区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetWrateMockForHozen.class, "exec", 0, 13), pKeikaNensuu, "経過年数");
    }

    private void checkKeisanVParameter(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, KeisanWExtBean pKeisanWExtBean, int pKeikaNensuu, int pKeikaTukisuu, C_TyksenhokanhouKbn pTyksenhokanhouKbn) {
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 0), pCalckijyunYmd, "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 1), pCalckijyunYm, "計算基準年月");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 2), pKeisanWExtBean.getKykymd(), "契約日");
        exStringEquals((String) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 3), pKeisanWExtBean.getSyouhncd(), "商品コード");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 4), pKeisanWExtBean.getSyouhnsdno(), "商品世代番号");
        exStringEquals((String) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 5), pKeisanWExtBean.getRyouritusdno(), "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 6), pKeisanWExtBean.getYoteiriritu(), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 7), pKeisanWExtBean.getHrkkaisuu(), "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 8), pKeisanWExtBean.getHhknsei(), "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 9), pKeisanWExtBean.getHhknnen(), "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 10), pKeisanWExtBean.getHknkknsmnkbn(), "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 11), pKeisanWExtBean.getHknkkn(), "保険期間");
        exClassificationEquals((C_HrkkknsmnKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 12), pKeisanWExtBean.getHrkkknsmnkbn(), "払込期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 13), pKeisanWExtBean.getHrkkkn(), "払込期間");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 14), pKeisanWExtBean.getKihons(), "基本Ｓ");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 15), pKeikaNensuu, "経過年数");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 16), pKeikaTukisuu, "経過月数");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 17), pKeisanWExtBean.getTuukasyu(), "契約通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 18), pKeisanWExtBean.getHokenryou(), "保険料");
        exClassificationEquals((C_TyksenhokanhouKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 19), pTyksenhokanhouKbn, "直線補間方法区分");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 20), pKeisanWExtBean.getKykJyoutai(), "契約状態");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 21), pKeisanWExtBean.getDai1hknkkn(), "第１保険期間");
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetWrateMockForHozen.SYORIPTN = BzGetWrateMockForHozen.TESTPATTERN1;

        BizDate pCalckijyunYmd = BizDate.valueOf(20210315);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202103);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkErrorResult(resultKbn);
        checkBzGetWrateParameter(pKeisanWExtBean, C_Kykjyoutai.HRKMTYUU, C_WRateGetKbn.TWOYEARS, 1);
    }

    @Test
    @TestOrder(10)
    public void testExec_A2() {

        MockObjectManager.initialize();
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;

        BizDate pCalckijyunYmd = BizDate.valueOf(20260615);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202606);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkErrorResult(resultKbn);
        checkKeisanVParameter(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean, 6, 4, C_TyksenhokanhouKbn.RATE);
    }

    @Test
    @TestOrder(1010)
    public void testExec_B1() {

        MockObjectManager.initialize();
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate pCalckijyunYmd = BizDate.valueOf(20250301);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202503);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkSuccessResult(resultKbn, BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), 5, 1);
        checkKeisanVParameter(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean, 5, 1, C_TyksenhokanhouKbn.RATE);
    }

    @Test
    @TestOrder(1020)
    public void testExec_B2() {

        MockObjectManager.initialize();
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate pCalckijyunYmd = BizDate.valueOf(20250301);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202502);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkSuccessResult(resultKbn, BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), 5, 0);
        checkKeisanVParameter(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean, 5, 0, C_TyksenhokanhouKbn.RATE);
    }

    @Test
    @TestOrder(1030)
    public void testExec_B3() {

        MockObjectManager.initialize();
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate pCalckijyunYmd = BizDate.valueOf(20250228);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202502);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkSuccessResult(resultKbn, BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), 5, 0);
        checkKeisanVParameter(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean, 5, 0, C_TyksenhokanhouKbn.RATE);
    }

    @Test
    @TestOrder(1040)
    public void testExec_B4() {

        MockObjectManager.initialize();
        BzGetWrateMockForHozen.SYORIPTN = BzGetWrateMockForHozen.TESTPATTERN2;

        BizDate pCalckijyunYmd = BizDate.valueOf(20250227);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202502);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_NENMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkSuccessResult(resultKbn, BizCurrency.valueOf(6156.15, BizCurrencyTypes.DOLLAR), 5, 0);
        checkBzGetWrateParameter(pKeisanWExtBean, C_Kykjyoutai.HRKMTYUU, C_WRateGetKbn.TWOYEARS, 5);
    }

    @Test
    @TestOrder(1050)
    public void testExec_B5() {

        MockObjectManager.initialize();
        BzGetWrateMockForHozen.SYORIPTN = BzGetWrateMockForHozen.TESTPATTERN2;

        BizDate pCalckijyunYmd = BizDate.valueOf(20200701);
        BizDateYM pCalckijyunYm = BizDateYM.valueOf(202007);
        KeisanWExtBean pKeisanWExtBean = createKeisanWExtBean(PARAMETER_SAIMANKI);

        C_ErrorKbn resultKbn = keisanWHyojyun.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);

        checkSuccessResult(resultKbn, BizCurrency.valueOf(7323.81, BizCurrencyTypes.DOLLAR), 0, 5);
        checkBzGetWrateParameter(pKeisanWExtBean, C_Kykjyoutai.HRKMTYUU, C_WRateGetKbn.TWOYEARS, 0);
    }
}
