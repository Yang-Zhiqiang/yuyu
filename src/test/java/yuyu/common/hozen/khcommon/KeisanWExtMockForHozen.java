package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 解約返戻金計算拡張情報作成クラス{@link KeisanWExt}のモッククラスです。<br />
 */
public class KeisanWExtMockForHozen extends KeisanWExt {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(String pSyono, BizDate pCalcKijyunYmd) {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
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
        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
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
            else if (SYORIPTN != null) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditSuiihyouTblSyuusin3Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
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
        else if (caller == EditSuiihyouTblNenkin3Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pSyono, pCalcKijyunYmd);
    }

    @Override
    public KeisanWExtBean getKeisanWExtBean() {
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if(TESTPATTERN1.equals(TESTPATTERN1)) {
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

        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            keisanWExtBean.setHokenryou(BizCurrency.valueOf(100.9));
        }

        else if (caller == EditSuiihyouTblSyuusin2Test_editTBL.class) {
            if (SYORIPTN != null) {
                if (TESTPATTERN2.equals(SYORIPTN)||TESTPATTERN4.equals(SYORIPTN)) {
                    keisanWExtBean.setSyouhncd("ﾕF");
                    keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
                    keisanWExtBean.setHhknnen(30);
                }
                else if (TESTPATTERN3.equals(SYORIPTN)) {
                    keisanWExtBean.setSyouhncd("ﾕﾉ");
                    keisanWExtBean.setTuukasyu(C_Tuukasyu.AUD);
                    keisanWExtBean.setHhknnen(31);

                }
                else if(TESTPATTERN5.equals(SYORIPTN)){
                    keisanWExtBean.setSyouhncd("ﾕF");
                    keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
                    keisanWExtBean.setHhknnen(35);
                }
                keisanWExtBean.setSyouhnsdno(1);
                keisanWExtBean.setRyouritusdno("K");
                keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.9999));
                keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
                keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
                keisanWExtBean.setHknkkn(99);
                keisanWExtBean.setHrkkkn(0);
                keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
                if (TESTPATTERN4.equals(SYORIPTN)||TESTPATTERN5.equals(SYORIPTN)) {
                    keisanWExtBean.setKykymd(BizDate.valueOf(20200911));
                    keisanWExtBean.setYendthnkymd(BizDate.valueOf(20210912));
                    keisanWExtBean.setKihons(BizCurrency.valueOf(2000000,BizCurrencyTypes.YEN));
                    keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
                    keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.ZERO);
                    keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.ZERO);
                    keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.0005));
                }else{
                    keisanWExtBean.setKykymd(BizDate.valueOf(20200930));
                    keisanWExtBean.setKihons(BizCurrency.valueOf(22222));
                    keisanWExtBean.setHokenryou(BizCurrency.valueOf(33333));
                    keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.99));
                    keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.99));
                }

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
        return super.getKeisanWExtBean();
    }
}
