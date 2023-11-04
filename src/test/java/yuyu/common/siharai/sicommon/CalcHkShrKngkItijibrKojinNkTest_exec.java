package yuyu.common.siharai.sicommon;

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

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWMockForSiharai;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金額計算（一時払個人年金）クラスのメソッド {@link CalcHkShrKngkItijibrKojinNk#exec(CalcHkShrKngkInputBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcHkShrKngkItijibrKojinNkTest_exec {

    @Inject
    private CalcHkShrKngkItijibrKojinNk CalcHkShrKngkItijibrKojinNk;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        MockObjectManager.initialize();

        KeisanWMockForSiharai.caller = CalcHkShrKngkItijibrKojinNkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeisanWMockForSiharai.caller = null;
        KeisanWMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(100)
    public void testExec_A01() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(null);
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200201));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(110)
    public void testExec_A02() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setCalckijyunymd(null);
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(120)
    public void testExec_A03() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(null);
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200201));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(130)
    public void testExec_A04() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200201));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(null);
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(140)
    public void testExec_A05() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.optional(BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200201));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(150)
    public void testExec_A06() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200201));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(5);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.SG);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.optional(BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(200)
    public void testExec_B01() {

        KeisanWMockForSiharai.SYORIPTN = "1";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200203));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.AUD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
    }

    @Test
    @TestOrder(300)
    public void testExec_C01() {

        KeisanWMockForSiharai.SYORIPTN = "2";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20200801));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200731));
        calcHkShrKngkInputBean.setSyono("20000000001");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.USD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.4321));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR),"定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR),"指数連動積立金額");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(HenkanTuuka.class, "henkanTuukaKbnToType",
            1, 0), C_Tuukasyu.USD, "通貨種類");
    }

    @Test
    @TestOrder(310)
    public void testExec_C02() {

        KeisanWMockForSiharai.SYORIPTN = "3";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.FEMALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("6000001000006"), BizCurrencyTypes.EURO));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20200202));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200202));
        calcHkShrKngkInputBean.setSyono("20000000002");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.EUR);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("3000004000003"), BizCurrencyTypes.EURO));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.EURO));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("2300000"), BizCurrencyTypes.EURO));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(null);
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("6000001000006"),
            BizCurrencyTypes.EURO), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("5000002000005"),
            BizCurrencyTypes.EURO), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("7000003000007"),
            BizCurrencyTypes.EURO), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("3000004000003"),
            BizCurrencyTypes.EURO), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("7000003000007"),
            BizCurrencyTypes.EURO), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.EURO), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("7000003000007"),
            BizCurrencyTypes.EURO), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.EURO),"定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("2300000"),
            BizCurrencyTypes.EURO),"指数連動積立金額");
    }

    @Test
    @TestOrder(320)
    public void testExec_C03() {

        KeisanWMockForSiharai.SYORIPTN = "4";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200203));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.AUD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202002));
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(BizDate.valueOf(20170203));

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR),"定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR),"指数連動積立金額");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 2, 0),
            BizDate.valueOf(20200203), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 2, 1),
            BizDateYM.valueOf(202002), "基準年月");
        KeisanWExtBean keisanWExtBean = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 2, 2);
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕｻ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 78, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(),C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0),"解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0),"契約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(202012), "積立金対象年月日");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR),"定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR),"指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(1.2345),"積立利率");
        exDateEquals(keisanWExtBean.getYendthnkymd(), BizDate.valueOf(20170203), "円建変更日");
    }

    @Test
    @TestOrder(330)
    public void testExec_C04() {

        KeisanWMockForSiharai.SYORIPTN = "5";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕｻ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(56);
        calcHkShrKngkInputBean.setHrkkkn(78);
        calcHkShrKngkInputBean.setHhknnen(90);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.YEN));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200203));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.JPY);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.YEN));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym((BizDateYM.valueOf(202012)));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.YEN));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.YEN));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.BLNK);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202002));
        calcHkShrKngkInputBean.setPtmttKngk(null);
        calcHkShrKngkInputBean.setKihrkmPStgk(null);
        calcHkShrKngkInputBean.setFstPryosyuYmd(null);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);
        calcHkShrKngkInputBean.setYendthnkYmd(BizDate.valueOf(20170203));

        C_ErrorKbn errorKbn = CalcHkShrKngkItijibrKojinNk.exec(calcHkShrKngkInputBean);
        CalcHkShrKngkBean calcHkShrKngkBean = CalcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.YEN), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.YEN),"定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.YEN),"指数連動積立金額");
    }

}

