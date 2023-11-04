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

import yuyu.common.hozen.khcommon.KeisanV;
import yuyu.common.hozen.khcommon.KeisanVMockForSiharai;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWMockForSiharai;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 死亡日解約返戻金取得クラスのメソッド {@link GetSibouymdW#exec(CalcHkShrKngkInputBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSibouymdWTest_exec {

    @Inject
    private GetSibouymdW GetSibouymdW;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForSiharai.class);
                bind(KeisanV.class).to(KeisanVMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        MockObjectManager.initialize();
        KeisanWMockForSiharai.caller = GetSibouymdWTest_exec.class;
        KeisanVMockForSiharai.caller = GetSibouymdWTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeisanWMockForSiharai.caller = null;
        KeisanWMockForSiharai.SYORIPTN = null;
        KeisanVMockForSiharai.caller = null;
        KeisanVMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(100)
    public void testExec_A01() {

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕﾆ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
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
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202001));
        calcHkShrKngkInputBean.setPtmttKngk(BizCurrency.valueOf(Long.valueOf("3000004000003"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setKihrkmPStgk(BizCurrency.valueOf(Long.valueOf("6000004000006"), BizCurrencyTypes.DOLLAR));
        calcHkShrKngkInputBean.setFstPryosyuYmd(BizDate.valueOf(20160201));
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(1.5432));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = GetSibouymdW.exec(calcHkShrKngkInputBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(GetSibouymdW.getKaiyakuhenreiknGk(), null, "解約返戻金額");
        exBizCalcbleEquals(GetSibouymdW.getTmttKnGk(), null, "積立金額");
        exBizCalcbleEquals(GetSibouymdW.getPruikei(), null, "保険料累計");
    }

    @Test
    @TestOrder(200)
    public void testExec_B01() {

        KeisanWMockForSiharai.SYORIPTN = "1";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕﾆ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
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
        calcHkShrKngkInputBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202006));
        calcHkShrKngkInputBean.setPtmttKngk(BizCurrency.valueOf(Long.valueOf("2000005000002"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKihrkmPStgk(BizCurrency.valueOf(Long.valueOf("7000006000007"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setFstPryosyuYmd(BizDate.valueOf(20160301));
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(1.5432));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        calcHkShrKngkInputBean.setYendthnkYmd(null);

        C_ErrorKbn errorKbn = GetSibouymdW.exec(calcHkShrKngkInputBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(GetSibouymdW.getKaiyakuhenreiknGk(), null, "解約返戻金額");
        exBizCalcbleEquals(GetSibouymdW.getTmttKnGk(), null, "積立金額");
        exBizCalcbleEquals(GetSibouymdW.getPruikei(), null, "保険料累計");
    }

    @Test
    @TestOrder(300)
    public void testExec_C01() {

        KeisanWMockForSiharai.SYORIPTN = "2";

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾕﾆ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(45);
        calcHkShrKngkInputBean.setHrkkkn(40);
        calcHkShrKngkInputBean.setHhknnen(30);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("3000007000003"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200204));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.AUD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202003));
        calcHkShrKngkInputBean.setPtmttKngk(BizCurrency.valueOf(Long.valueOf("9000007000008"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKihrkmPStgk(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setFstPryosyuYmd(BizDate.valueOf(20160301));
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(1.5432));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        calcHkShrKngkInputBean.setYendthnkYmd(BizDate.valueOf(20170203));

        C_ErrorKbn errorKbn = GetSibouymdW.exec(calcHkShrKngkInputBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(GetSibouymdW.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(GetSibouymdW.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(GetSibouymdW.getPruikei(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "保険料累計");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 1, 0),
            BizDate.valueOf(20200204), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 1, 1),
            BizDateYM.valueOf(202003), "基準年月");
        KeisanWExtBean keisanWExtBean = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForSiharai.class, "exec", 1, 2);
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕﾆ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 45, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 40, "払込期間");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(),C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000007000003"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("9000007000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0),"解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0),"契約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), BizDateYM.valueOf(202012), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR),"定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR),"指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(1.2345),"積立利率");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), BizDateYM.valueOf(202003), "次回Ｐ充当年月");
        exBizCalcbleEquals(keisanWExtBean.getPtmttkngk(), BizCurrency.valueOf(Long.valueOf("9000007000008"),
            BizCurrencyTypes.AU_DOLLAR),"保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean.getKihrkmpstgk(), BizCurrency.valueOf(Long.valueOf("9000007000009"),
            BizCurrencyTypes.AU_DOLLAR),"既払込保険料相当額");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), BizDate.valueOf(20160301), "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.valueOf(1.5432),"予定利率変動時保証利率");
        exDateEquals(keisanWExtBean.getYendthnkymd(), BizDate.valueOf(20170203), "円建変更日");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
    }

    @Test
    @TestOrder(400)
    public void testExec_C02() {

        KeisanWMockForSiharai.SYORIPTN = "2";
        KeisanVMockForSiharai.SYORIPTN = "1";
        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾆｱ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(45);
        calcHkShrKngkInputBean.setHrkkkn(40);
        calcHkShrKngkInputBean.setHhknnen(30);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("3000007000003"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200204));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.AUD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202003));
        calcHkShrKngkInputBean.setPtmttKngk(BizCurrency.valueOf(Long.valueOf("9000007000008"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKihrkmPStgk(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setFstPryosyuYmd(BizDate.valueOf(20160301));
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(1.5432));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        calcHkShrKngkInputBean.setYendthnkYmd(BizDate.valueOf(20170203));
        BM_SyouhnZokusei bm_SyouhnZokusei = new BM_SyouhnZokusei();
        bm_SyouhnZokusei.setTyksenhokanhoukbn(C_TyksenhokanhouKbn.RATE);
        calcHkShrKngkInputBean.setSyouhnZokusei(bm_SyouhnZokusei);

        C_ErrorKbn errorKbn = GetSibouymdW.exec(calcHkShrKngkInputBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(GetSibouymdW.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(GetSibouymdW.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("200")), "積立金額");
        exBizCalcbleEquals(GetSibouymdW.getPruikei(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "保険料累計");
    }

    @Test
    @TestOrder(500)
    public void testExec_C03() {

        KeisanWMockForSiharai.SYORIPTN = "2";
        KeisanVMockForSiharai.SYORIPTN = "2";
        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd("ﾆｱ");
        calcHkShrKngkInputBean.setSyouhnsdno(1);
        calcHkShrKngkInputBean.setRyouritusdno("789");
        calcHkShrKngkInputBean.setYoteiriritu(BizNumber.valueOf(0.1234));
        calcHkShrKngkInputBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        calcHkShrKngkInputBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setHknkkn(45);
        calcHkShrKngkInputBean.setHrkkkn(40);
        calcHkShrKngkInputBean.setHhknnen(30);
        calcHkShrKngkInputBean.setHhknsei(C_Hhknsei.MALE);
        calcHkShrKngkInputBean.setKihons(BizCurrency.valueOf(Long.valueOf("3000007000003"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKykymd(BizDate.valueOf(20160203));
        calcHkShrKngkInputBean.setCalckijyunymd(BizDate.valueOf(20200204));
        calcHkShrKngkInputBean.setSyono("20000000003");
        calcHkShrKngkInputBean.setTuukasyu(C_Tuukasyu.AUD);
        calcHkShrKngkInputBean.setDai1hknkkn(0);
        calcHkShrKngkInputBean.setSiinkbn(C_SiinKbn.BLNK);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);
        calcHkShrKngkInputBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        calcHkShrKngkInputBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
        calcHkShrKngkInputBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setTumitateriritu(BizNumber.valueOf(1.2345));
        calcHkShrKngkInputBean.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
        calcHkShrKngkInputBean.setJkipjytYm(BizDateYM.valueOf(202003));
        calcHkShrKngkInputBean.setPtmttKngk(BizCurrency.valueOf(Long.valueOf("9000007000008"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setKihrkmPStgk(BizCurrency.valueOf(Long.valueOf("9000007000009"), BizCurrencyTypes.AU_DOLLAR));
        calcHkShrKngkInputBean.setFstPryosyuYmd(BizDate.valueOf(20160301));
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(BizNumber.valueOf(1.5432));
        calcHkShrKngkInputBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        calcHkShrKngkInputBean.setYendthnkYmd(BizDate.valueOf(20170203));
        BM_SyouhnZokusei bm_SyouhnZokusei = new BM_SyouhnZokusei();
        bm_SyouhnZokusei.setTyksenhokanhoukbn(C_TyksenhokanhouKbn.RATE);
        calcHkShrKngkInputBean.setSyouhnZokusei(bm_SyouhnZokusei);

        C_ErrorKbn errorKbn = GetSibouymdW.exec(calcHkShrKngkInputBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(GetSibouymdW.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(GetSibouymdW.getTmttKnGk(), null, "積立金額");
        exBizCalcbleEquals(GetSibouymdW.getPruikei(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "保険料累計");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 0),
            BizDate.valueOf(20200204), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 1),
            BizDateYM.valueOf(202003), "基準年月");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 2),
            BizDate.valueOf(20160203), "契約日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 3),
            "ﾆｱ", "商品コード");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 4),
            1, "商品世代番号");
        exStringEquals((String)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 5),
            "789", "料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 6),
            BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 7),
            C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 8),
            C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 9),
            30, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 10),
            C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 11),
            45, "保険期間");
        exClassificationEquals((C_HrkkknsmnKbn)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 12),
            C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 13),
            40, "払込期間");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 14),
            BizCurrency.valueOf(Long.valueOf("3000007000003"),
                BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 15),
            0, "経過年数");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 16),
            0, "経過月数");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 17),
            C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 18),
            BizCurrency.valueOf(Long.valueOf("9000007000009"),
                BizCurrencyTypes.AU_DOLLAR), "保険料");
        exClassificationEquals((C_TyksenhokanhouKbn)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 19),
            C_TyksenhokanhouKbn.RATE, "直線補間方法区分");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 20),
            C_Kykjyoutai.HRKMTYUU, "契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanVMockForSiharai.class, "exec", 1, 21),
            0, "第１保険期間");
    }
}
