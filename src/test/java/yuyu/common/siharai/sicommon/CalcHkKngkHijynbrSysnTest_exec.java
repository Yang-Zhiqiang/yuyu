package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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

import com.google.inject.AbstractModule;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 保険金額計算（平準払終身）クラスのメソッド {@link CalcHkKngkHijynbrSysn#exec(CalcHkShrKngkInputBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcHkKngkHijynbrSysnTest_exec {

    @Inject
    private CalcHkKngkHijynbrSysn calcHkKngkHijynbrSysn;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SiCalcKihrkmpstgk.class).to(SiCalcKihrkmpstgkMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        SiCalcKihrkmpstgkMockForSiharai.caller = CalcHkKngkHijynbrSysnTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SiCalcKihrkmpstgkMockForSiharai.caller =null;
        SiCalcKihrkmpstgkMockForSiharai.SYORIPTN =null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
        calcHkShrKngkInputBean.setKykymd(null);
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20201125));

        C_ErrorKbn errorKbn = calcHkKngkHijynbrSysn.exec(calcHkShrKngkInputBean);

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();

        BizDate calcKijyunYmd = calcHkKngkHijynbrSysn.getCalcKijyunYmd();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exDateEquals(calcKijyunYmd,null,"計算基準日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20201125));
        calcHkShrKngkInputBean.setCalckijyunymd(null);

        C_ErrorKbn errorKbn = calcHkKngkHijynbrSysn.exec(calcHkShrKngkInputBean);

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();

        BizDate calcKijyunYmd = calcHkKngkHijynbrSysn.getCalcKijyunYmd();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exDateEquals(calcKijyunYmd,null,"計算基準日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SiCalcKihrkmpstgkMockForSiharai.SYORIPTN = SiCalcKihrkmpstgkMockForSiharai.TESTPATTERN1;

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
        calcHkShrKngkInputBean.setSyouhncd("ﾕｱ");
        calcHkShrKngkInputBean.setRyouritusdno("101");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(10));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setHknkkn(2);
        calcHkShrKngkInputBean.setHrkkkn(3);
        calcHkShrKngkInputBean.setHhknnen(99);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(1001));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20201126));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20201125));
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.JPY);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(2002));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.PMEN);
        BM_SyouhnZokusei bm_SyouhnZokusei = new BM_SyouhnZokusei();
        bm_SyouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        calcHkShrKngkInputBean.setSyouhnZokusei(bm_SyouhnZokusei);
        calcHkShrKngkInputBean.setSdpdkbn(C_Sdpd.PD);
        calcHkShrKngkInputBean.setHrkkeiro(C_Hrkkeiro.CREDIT);

        C_ErrorKbn errorKbn = calcHkKngkHijynbrSysn.exec(calcHkShrKngkInputBean);
        SiCalcKihrkmpstgkBean pSiCalcKihrkmpstgkBean = (SiCalcKihrkmpstgkBean) MockObjectManager.getArgument(
            SiCalcKihrkmpstgkMockForSiharai.class, "exec", 0, 0);
        exStringEquals(pSiCalcKihrkmpstgkBean.getSyouhnCd(),"ﾕｱ","商品コード");
        exStringEquals(pSiCalcKihrkmpstgkBean.getRyouriTusdNo(),"101","料率世代番号");
        exBizCalcbleEquals(pSiCalcKihrkmpstgkBean.getYoteiRiritu(),BizNumber.valueOf(10),"予定利率");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getHrkKaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getHknkknSmnKbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(pSiCalcKihrkmpstgkBean.getHknKkn(), 2, "保険期間");
        exNumericEquals(pSiCalcKihrkmpstgkBean.getHrkKkn(), 3, "払込期間");
        exNumericEquals(pSiCalcKihrkmpstgkBean.getHhknNen(), 99, "被保険者年齢");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getHhknSei(),C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(pSiCalcKihrkmpstgkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf(1001)), "基本Ｓ");
        exDateEquals(pSiCalcKihrkmpstgkBean.getKykYmd(), BizDate.valueOf(20201126), "契約日");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getKykTuukaSyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(pSiCalcKihrkmpstgkBean.getCalcKijyunYmd(), BizDate.valueOf(20201126), "計算基準日");
        exNumericEquals(pSiCalcKihrkmpstgkBean.getDai1HknKkn(), 5, "第１保険期間");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(),BizCurrency.valueOf(2002), "保険料");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getHrkkknSmnKbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getKykJyoutai(), C_Kykjyoutai.PMEN, "契約状態");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getSdPdKbn(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals(pSiCalcKihrkmpstgkBean.getHrkKeiro(), C_Hrkkeiro.CREDIT, "払込経路");

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();

        BizDate calcKijyunYmd = calcHkKngkHijynbrSysn.getCalcKijyunYmd();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("1001")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("1003")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("1003")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("1003")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exDateEquals(calcKijyunYmd,BizDate.valueOf(20201126),"計算基準日");



    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SiCalcKihrkmpstgkMockForSiharai.SYORIPTN = SiCalcKihrkmpstgkMockForSiharai.TESTPATTERN2;

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
        calcHkShrKngkInputBean.setSyouhncd("ﾕｱ");
        calcHkShrKngkInputBean.setRyouritusdno("101");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(10));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setHknkkn(2);
        calcHkShrKngkInputBean.setHrkkkn(3);
        calcHkShrKngkInputBean.setHhknnen(99);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(1001));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20181125));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20201126));
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.JPY);
        calcHkShrKngkInputBean.setDai1hknkkn(1);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(2002));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.PMEN);
        BM_SyouhnZokusei bm_SyouhnZokusei = new BM_SyouhnZokusei();
        bm_SyouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        calcHkShrKngkInputBean.setSyouhnZokusei(bm_SyouhnZokusei);
        calcHkShrKngkInputBean.setSdpdkbn(C_Sdpd.BLNK);
        calcHkShrKngkInputBean.setHrkkeiro(C_Hrkkeiro.CREDIT);

        C_ErrorKbn errorKbn = calcHkKngkHijynbrSysn.exec(calcHkShrKngkInputBean);

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();

        BizDate calcKijyunYmd = calcHkKngkHijynbrSysn.getCalcKijyunYmd();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("1001")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("1003")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("1001")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("1001")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI2HKNKKN, "保険期間区分");
        exDateEquals(calcKijyunYmd,BizDate.valueOf(20201126),"計算基準日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SiCalcKihrkmpstgkMockForSiharai.SYORIPTN = SiCalcKihrkmpstgkMockForSiharai.TESTPATTERN3;

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
        calcHkShrKngkInputBean.setSyouhncd("ﾕｱ");
        calcHkShrKngkInputBean.setRyouritusdno("101");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(10));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setHknkkn(2);
        calcHkShrKngkInputBean.setHrkkkn(3);
        calcHkShrKngkInputBean.setHhknnen(99);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(1001));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20181125));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20201125));
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.EUR);
        calcHkShrKngkInputBean.setDai1hknkkn(7);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(2002));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.PMEN);

        BM_SyouhnZokusei bm_SyouhnZokusei = new BM_SyouhnZokusei();
        bm_SyouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        calcHkShrKngkInputBean.setSyouhnZokusei(bm_SyouhnZokusei);
        calcHkShrKngkInputBean.setSdpdkbn(C_Sdpd.BLNK);
        calcHkShrKngkInputBean.setHrkkeiro(C_Hrkkeiro.CREDIT);

        C_ErrorKbn errorKbn = calcHkKngkHijynbrSysn.exec(calcHkShrKngkInputBean);

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();

        BizDate calcKijyunYmd = calcHkKngkHijynbrSysn.getCalcKijyunYmd();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("1001")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0"),BizCurrencyTypes.EURO), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0"),BizCurrencyTypes.EURO), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("1003")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("1003")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),BizCurrencyTypes.EURO), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("1003")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exDateEquals(calcKijyunYmd,BizDate.valueOf(20201125),"計算基準日");
    }

}
