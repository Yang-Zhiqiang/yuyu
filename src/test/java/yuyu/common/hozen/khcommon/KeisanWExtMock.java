package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanWExt}のモッククラスです。<br />
 */
public class KeisanWExtMock extends KeisanWExt {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(String pSyono, BizDate pCalcKijyunYmd) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditSuiihyouTblTest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.ERROR;
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditSuiihyouTblNenkinTest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditSuiihyouTblSyuusin2Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyono, pCalcKijyunYmd);
    }

    @Override
    public KeisanWExtBean getKeisanWExtBean() {
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            keisanWExtBean.setHokenryou(BizCurrency.valueOf(100.9));
        }
        else if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN2.equals(SYORIPTN)) {

            keisanWExtBean.setSyouhncd("1001");
            keisanWExtBean.setSyouhnsdno(11);
            keisanWExtBean.setRyouritusdno("21");
            keisanWExtBean.setYoteiriritu(BizNumber.valueOf(40));
            keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
            keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
            keisanWExtBean.setHknkkn(13);
            keisanWExtBean.setHrkkkn(8);
            keisanWExtBean.setHhknnen(26);
            keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
            keisanWExtBean.setKihons(BizCurrency.valueOf(123132));
            keisanWExtBean.setHokenryou(BizCurrency.valueOf(30));
            keisanWExtBean.setKykymd(BizDate.valueOf(20160608));
            keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
            keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(40));

            return keisanWExtBean;
        }
        else if (caller == CalcHkShrKngkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                keisanWExtBean.setSyouhncd("ﾕｱ");
                keisanWExtBean.setSyouhnsdno(1);
                return keisanWExtBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keisanWExtBean.setSyouhncd("ﾕｻ");
                keisanWExtBean.setSyouhnsdno(1);
                keisanWExtBean.setRyouritusdno("789");
                keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.1234));
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
                keisanWExtBean.setHknkkn(56);
                keisanWExtBean.setHrkkkn(78);
                keisanWExtBean.setHhknnen(90);
                keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
                keisanWExtBean.setKihons(BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setKykymd(BizDate.valueOf(20160203));
                keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.1234));
                keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.5432));
                keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
                keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setTumitateriritu(BizNumber.valueOf(1.2345));
                keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
                keisanWExtBean.setJkipjytym(null);
                keisanWExtBean.setPtmttkngk(null);
                keisanWExtBean.setKihrkmpstgk(null);
                keisanWExtBean.setFstpryosyuymd(null);
                keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
                keisanWExtBean.setYendthnkymd(BizDate.valueOf(20170203));
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keisanWExtBean.setSyouhncd("ﾕﾅ");
                keisanWExtBean.setSyouhnsdno(1);
                keisanWExtBean.setRyouritusdno("789");
                keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.1234));
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
                keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
                keisanWExtBean.setHknkkn(56);
                keisanWExtBean.setHrkkkn(2);
                keisanWExtBean.setHhknnen(90);
                keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
                keisanWExtBean.setKihons(BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setKykymd(BizDate.valueOf(20160203));
                keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
                keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
                keisanWExtBean.setTmttkntaisyouym(null);
                keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
                keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
                keisanWExtBean.setJkipjytym(BizDateYM.valueOf(202002));
                keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(Long.valueOf("9000009000009"), BizCurrencyTypes.AU_DOLLAR));
                keisanWExtBean.setFstpryosyuymd(null);
                keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1234));
                keisanWExtBean.setYendthnkymd(BizDate.valueOf(20170203));
            }
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if(TESTPATTERN1.equals(TESTPATTERN1)) {
                keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                return keisanWExtBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                return keisanWExtBean;
            }
        }
        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
            if(TESTPATTERN2.equals(TESTPATTERN2)) {
                keisanWExtBean.setSyouhncd("ﾕｻ");
                keisanWExtBean.setSyouhnsdno(2);
                keisanWExtBean.setRyouritusdno("789");
                return keisanWExtBean;
            }
        }
        else if (caller == EditSuiihyouTblNenkinTest_editTBL.class) {
            if(TESTPATTERN2.equals(TESTPATTERN2)) {
                keisanWExtBean.setSyouhncd("ﾕｱ");
                keisanWExtBean.setSyouhnsdno(1);
                keisanWExtBean.setRyouritusdno("789");
                keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.1234));
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
                keisanWExtBean.setHknkkn(56);
                keisanWExtBean.setHrkkkn(78);
                keisanWExtBean.setHhknnen(90);
                keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
                keisanWExtBean.setKihons(BizCurrency.valueOf(Long.valueOf("1000")));
                keisanWExtBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("2000")));
                keisanWExtBean.setKykymd(BizDate.valueOf(20160203));
                keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
                keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(1.5432));
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.1234));
                keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(202012));
                keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(Long.valueOf("3000")));
                keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(Long.valueOf("4000")));
                keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(1.2345));
                keisanWExtBean.setTumitateriritu(BizNumber.valueOf(1.2345));
                return keisanWExtBean;
            }
        }
        else if (caller == EditSuiihyouTblSyuusin2Test_editTBL.class) {
            if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                keisanWExtBean.setSyouhncd("B001");
                keisanWExtBean.setSyouhnsdno(2);
                keisanWExtBean.setRyouritusdno("K");
                keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.9999));
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
                keisanWExtBean.setHknkkn(90);
                keisanWExtBean.setHrkkkn(80);
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    keisanWExtBean.setHhknnen(30);
                }
                else if (TESTPATTERN3.equals(SYORIPTN)) {
                    keisanWExtBean.setHhknnen(31);
                }
                keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
                keisanWExtBean.setKihons(BizCurrency.valueOf(22222));
                keisanWExtBean.setHokenryou(BizCurrency.valueOf(33333));
                keisanWExtBean.setKykymd(BizDate.valueOf(20200930));
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
                }
                else if (TESTPATTERN3.equals(SYORIPTN)) {
                    keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);
                }
                keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.99));

                return keisanWExtBean;
            }
        }
        else {
            return super.getKeisanWExtBean();
        }

        return keisanWExtBean;

    }
}
