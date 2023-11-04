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

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約返戻金計算クラスのメソッド {@link KeisanW#exec(BizDate,BizDateYM,KeisanWExtBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWTest_exec {

    @Inject
    private KeisanW keisanW;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWItiji.class).to(KeisanWItijiMockForHozen.class);
                bind(KeisanWHyojyun.class).to(KeisanWHyojyunMockForHozen.class);
                bind(KeisanWHeijyun.class).to(KeisanWHeijyunMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWItijiMockForHozen.caller = KeisanWTest_exec.class;
        KeisanWHyojyunMockForHozen.caller = KeisanWTest_exec.class;
        KeisanWHeijyunMockForKhansyuu.caller = KeisanWTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KeisanWItijiMockForHozen.caller = null;
        KeisanWItijiMockForHozen.SYORIPTN = null;
        KeisanWHyojyunMockForHozen.caller = null;
        KeisanWHyojyunMockForHozen.SYORIPTN = null;
        KeisanWHeijyunMockForKhansyuu.caller = null;
        KeisanWHeijyunMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);

        C_ErrorKbn errorKbn = keisanW.exec(null, null, keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), null, "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), null, "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        KeisanWItijiMockForHozen.SYORIPTN = KeisanWItijiMockForHozen.TESTPATTERN10;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWItijiMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20201201), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWItijiMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(202012), "基準年月");
        KeisanWExtBean keisanWExtBeanTest = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWItijiMockForHozen.class, "exec", 0, 2);
        exStringEquals(keisanWExtBeanTest.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(keisanWExtBeanTest.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBeanTest.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.BLNK, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        KeisanWHyojyunMockForHozen.SYORIPTN = KeisanWHyojyunMockForHozen.TESTPATTERN1;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾆｱ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWHyojyunMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20201201), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWHyojyunMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(202012), "基準年月");
        KeisanWExtBean keisanWExtBeanTest = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWHyojyunMockForHozen.class, "exec", 0, 2);
        exStringEquals(keisanWExtBeanTest.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(keisanWExtBeanTest.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanWExtBeanTest.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.BLNK, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        KeisanWHeijyunMockForKhansyuu.SYORIPTN = KeisanWHeijyunMockForKhansyuu.TESTPATTERN1;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾁ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWHeijyunMockForKhansyuu.class, "exec", 0, 0),
            BizDate.valueOf(20201201), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWHeijyunMockForKhansyuu.class, "exec", 0, 1),
            BizDateYM.valueOf(202012), "基準年月");
        KeisanWExtBean keisanWExtBeanTest = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWHeijyunMockForKhansyuu.class, "exec", 0, 2);
        exStringEquals(keisanWExtBeanTest.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(keisanWExtBeanTest.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanWExtBeanTest.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.BLNK, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(1010)
    public void testExec_B1() {

        MockObjectManager.initialize();
        KeisanWItijiMockForHozen.SYORIPTN = KeisanWItijiMockForHozen.TESTPATTERN12;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(555, BizCurrencyTypes.AU_DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(444, BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(5.3), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(333, BizCurrencyTypes.AU_DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(2.1), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(222, BizCurrencyTypes.AU_DOLLAR), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 1, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 6, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 7, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(111, BizCurrencyTypes.AU_DOLLAR), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(9.1), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 1, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(345, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(543, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(12345, BizCurrencyTypes.AU_DOLLAR), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(1020)
    public void testExec_B2() {

        MockObjectManager.initialize();

        KeisanWHyojyunMockForHozen.SYORIPTN = KeisanWHyojyunMockForHozen.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾆｱ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(555, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 6, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 7, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.BLNK, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(1030)
    public void testExec_B3() {

        MockObjectManager.initialize();
        KeisanWHeijyunMockForKhansyuu.SYORIPTN = KeisanWHeijyunMockForKhansyuu.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾁ");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);

        C_ErrorKbn errorKbn = keisanW.exec(BizDate.valueOf(20201201), BizDateYM.valueOf(202012), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanW.getW(), BizCurrency.valueOf(21), "解約返戻金");
        exBizCalcbleEquals(keisanW.getV(), BizCurrency.valueOf(22), "積立金額");
        exBizCalcbleEquals(keisanW.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanW.getSjkkktyouseigk(), BizCurrency.valueOf(0), "市場価格調整額");
        exBizCalcbleEquals(keisanW.getKaiyakukjritu(), BizNumber.valueOf(23), "解約控除率");
        exBizCalcbleEquals(keisanW.getKaiyakukjgk(), BizCurrency.valueOf(24), "解約控除額");
        exNumericEquals(keisanW.getKaiyakukoujyoKeikaNensuu(), 25, "解約控除用経過年数");
        exNumericEquals(keisanW.getKeikanensuu(), 26, "経過年数");
        exNumericEquals(keisanW.getKeikatukisuu(), 27, "経過月数");
        exBizCalcbleEquals(keisanW.getCV(), BizCurrency.valueOf(0), "変額積立金（契約単位）");
        exClassificationEquals(keisanW.getFiSiyouKbn(), C_FiSiyouKbn.BLNK, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanW.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanW.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanW.getTeirituTmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanW.getSisuurendouTmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanW.getKaiyakukjMaeW(), BizCurrency.valueOf(28), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanW.getPruikei(), BizCurrency.valueOf(29), "保険料累計");
        exBizCalcbleEquals(keisanW.getPtumitatekinTyoseimae(), BizCurrency.valueOf(30), "保険料積立金（調整前）");
        exDateYMEquals(keisanW.getPtumitatekinKeisanYM(), BizDateYM.valueOf(201605), "保険料積立金計算年月");

    }
}
