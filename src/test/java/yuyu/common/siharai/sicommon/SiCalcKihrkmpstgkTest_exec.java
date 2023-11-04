package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSPMockForSiharai;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金給付金既払込保険料相当額計算のメソッド{@link SiCalcKihrkmpstgk#exec(SiCalcKihrkmpstgkBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiCalcKihrkmpstgkTest_exec {

    @Inject
    private SiCalcKihrkmpstgk siCalcKihrkmpstgk;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(KeisanSP.class).to(KeisanSPMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanSPMockForSiharai.caller = SiCalcKihrkmpstgkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanSPMockForSiharai.caller = null;
        KeisanSPMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201101"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20201031"));

        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201101"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20201101"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(21);
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.KOUHURI);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));

        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(123456789), "既払込保険料相当額");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201101"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20201102"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(2);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.CREDIT);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));

        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(123456789), "既払込保険料相当額");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201101"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20211031"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(1);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.HURIKAE);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));
        siCalcKihrkmpstgkBean.setSyouhnCd("s001");
        siCalcKihrkmpstgkBean.setRyouriTusdNo("01");
        siCalcKihrkmpstgkBean.setYoteiRiritu(BizNumber.valueOf(1.23));
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHhknSei(C_Hhknsei.MALE);
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(C_HknkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHknKkn(2);
        siCalcKihrkmpstgkBean.setHokenknGk(BizCurrency.valueOf(12345678));
        siCalcKihrkmpstgkBean.setKykTuukaSyu(C_Tuukasyu.JPY);
        siCalcKihrkmpstgkBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        siCalcKihrkmpstgkBean.setDai1HknKkn(3);


        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(1200), "既払込保険料相当額");

        exStringEquals((String)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 0), "s001", "商品コード");
        exStringEquals((String)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 1), "01", "料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 2), BizNumber.valueOf(1.23), "予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 4), 20, "被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 5), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 6), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 7), 2, "保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 8), 1, "払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 9), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 10), BizCurrency.valueOf(12345678), "保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 11), BizCurrency.valueOf(new BigDecimal(0), BizCurrencyTypes.YEN), "保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 12), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 13), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 14), 3, "第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(KeisanSPMockForSiharai.class, "exec", 0, 15), C_Hrkkeiro.KOUHURI, "払込経路");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN1;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201109"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20211108"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(1);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.KOUHURI);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));
        siCalcKihrkmpstgkBean.setSyouhnCd("s001");
        siCalcKihrkmpstgkBean.setRyouriTusdNo("01");
        siCalcKihrkmpstgkBean.setYoteiRiritu(BizNumber.valueOf(1.23));
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHhknSei(C_Hhknsei.MALE);
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(C_HknkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHknKkn(1);
        siCalcKihrkmpstgkBean.setHokenknGk(BizCurrency.valueOf(12345678));
        siCalcKihrkmpstgkBean.setKykTuukaSyu(C_Tuukasyu.JPY);
        siCalcKihrkmpstgkBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        siCalcKihrkmpstgkBean.setDai1HknKkn(1);


        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20191115"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20201115"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(1);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.SD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.KOUHURI);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));
        siCalcKihrkmpstgkBean.setSyouhnCd("s001");
        siCalcKihrkmpstgkBean.setRyouriTusdNo("01");
        siCalcKihrkmpstgkBean.setYoteiRiritu(BizNumber.valueOf(1.23));
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHhknSei(C_Hhknsei.MALE);
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(C_HknkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHknKkn(1);
        siCalcKihrkmpstgkBean.setHokenknGk(BizCurrency.valueOf(12345678));
        siCalcKihrkmpstgkBean.setKykTuukaSyu(C_Tuukasyu.JPY);
        siCalcKihrkmpstgkBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        siCalcKihrkmpstgkBean.setDai1HknKkn(1);


        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(1200), "既払込保険料相当額");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20200229"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20210302"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(1);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.KOUHURI);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));
        siCalcKihrkmpstgkBean.setSyouhnCd("s001");
        siCalcKihrkmpstgkBean.setRyouriTusdNo("01");
        siCalcKihrkmpstgkBean.setYoteiRiritu(BizNumber.valueOf(1.23));
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHhknSei(C_Hhknsei.MALE);
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(C_HknkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHknKkn(1);
        siCalcKihrkmpstgkBean.setHokenknGk(BizCurrency.valueOf(12345678));
        siCalcKihrkmpstgkBean.setKykTuukaSyu(C_Tuukasyu.JPY);
        siCalcKihrkmpstgkBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        siCalcKihrkmpstgkBean.setDai1HknKkn(1);


        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(1481481468), "既払込保険料相当額");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        KeisanSPMockForSiharai.SYORIPTN = KeisanSPMockForSiharai.TESTPATTERN2;

        SiCalcKihrkmpstgkBean siCalcKihrkmpstgkBean = SWAKInjector.getInstance(SiCalcKihrkmpstgkBean.class);

        siCalcKihrkmpstgkBean.setKykYmd(BizDate.valueOf("20201109"));
        siCalcKihrkmpstgkBean.setCalcKijyunYmd(BizDate.valueOf("20211108"));
        siCalcKihrkmpstgkBean.setHrkkknSmnKbn(C_HrkkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHrkKkn(1);
        siCalcKihrkmpstgkBean.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        siCalcKihrkmpstgkBean.setSdPdKbn(C_Sdpd.PD);
        siCalcKihrkmpstgkBean.setHrkKeiro(C_Hrkkeiro.KOUHURI);
        siCalcKihrkmpstgkBean.setHokenRyou(BizCurrency.valueOf(123456789));
        siCalcKihrkmpstgkBean.setSyouhnCd("s001");
        siCalcKihrkmpstgkBean.setRyouriTusdNo("01");
        siCalcKihrkmpstgkBean.setYoteiRiritu(BizNumber.valueOf(1.23));
        siCalcKihrkmpstgkBean.setHhknNen(20);
        siCalcKihrkmpstgkBean.setHhknSei(C_Hhknsei.MALE);
        siCalcKihrkmpstgkBean.setHknkknSmnKbn(C_HknkknsmnKbn.NENMANKI);
        siCalcKihrkmpstgkBean.setHknKkn(1);
        siCalcKihrkmpstgkBean.setHokenknGk(BizCurrency.valueOf(12345678));
        siCalcKihrkmpstgkBean.setKykTuukaSyu(C_Tuukasyu.JPY);
        siCalcKihrkmpstgkBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        siCalcKihrkmpstgkBean.setDai1HknKkn(1);


        C_ErrorKbn errorKbn = siCalcKihrkmpstgk.exec(siCalcKihrkmpstgkBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(siCalcKihrkmpstgk.getKiHrkmpstGk(), BizCurrency.valueOf(1200), "既払込保険料相当額");
    }
}
