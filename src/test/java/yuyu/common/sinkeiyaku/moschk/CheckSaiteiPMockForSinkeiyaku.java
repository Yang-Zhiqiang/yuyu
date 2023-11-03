package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 最低Pチェック{@link CheckSaiteiP}のモッククラスです。<br />
 */
public class CheckSaiteiPMockForSinkeiyaku extends CheckSaiteiP {

    public static final String TESTPATTERN1 = "2";

    public static final String TESTPATTERN2 = "1";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static final String TESTPATTERN23 = "23";

    public static final String TESTPATTERN24 = "24";

    public static final String TESTPATTERN25 = "25";

    public static final String TESTPATTERN32 = "32";

    public static final String TESTPATTERN33 = "33";

    public static final String TESTPATTERN34 = "34";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp, HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHntiP, C_Tuukasyu pTuukasyu) {
        if (caller == CheckSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }
        else if (caller == CheckSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return;
        }
        if (caller == CheckTblMosSyouhinTest_exec.class || caller == CheckTblMosSyouhinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        else {
            super.exec( pMp, pMosSyouhn,  pSyouhnZokusei ,pHntiP,  pTuukasyu);
        }
    }

    @Override
    public BizCurrency getSaiteiP(MosnaiCheckParam pMp, HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei) {
        if (caller == CheckTuusanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(800);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(240);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(71);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(20);
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(365);
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizCurrency.valueOf(230);
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return BizCurrency.valueOf(229);
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                return BizCurrency.valueOf(231);
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                return BizCurrency.valueOf(645);
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                return BizCurrency.valueOf(644);
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                return BizCurrency.valueOf(643);
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                return BizCurrency.valueOf(92);
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                return BizCurrency.valueOf(91);
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                return BizCurrency.valueOf(48);
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                return BizCurrency.valueOf(49);
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {
                return BizCurrency.valueOf(47);
            }
            else if (TESTPATTERN19.equals(SYORIPTN)) {
                return BizCurrency.valueOf(68);
            }
            else if (TESTPATTERN20.equals(SYORIPTN)) {
                return BizCurrency.valueOf(69);
            }
            else if (TESTPATTERN21.equals(SYORIPTN)) {
                return BizCurrency.valueOf(70);
            }
            else if (TESTPATTERN22.equals(SYORIPTN)) {
                return BizCurrency.valueOf(624);
            }
            else if (TESTPATTERN23.equals(SYORIPTN)) {
                return BizCurrency.valueOf(623);
            }
            else {
                return BizCurrency.valueOf(0);
            }
        }
        else if (caller == CheckTblMosSyouhinTest_exec5.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(0);
        }
        else if(caller == CheckSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){
            return BizCurrency.valueOf(0);
        }
        else if(caller == CheckSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)){
            return BizCurrency.valueOf(0);
        }
        else if (caller == CheckTuusanTest_exec2.class) {
            if (TESTPATTERN9.equals(SYORIPTN)) {

                return BizCurrency.valueOf(24);
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                return BizCurrency.valueOf(23);
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                return BizCurrency.valueOf(413);
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {

                return BizCurrency.valueOf(413, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {

                return BizCurrency.valueOf(413);
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {

                return BizCurrency.valueOf(413, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN23.equals(SYORIPTN)) {

                return BizCurrency.valueOf(160);
            }
            else if (TESTPATTERN24.equals(SYORIPTN)) {

                return BizCurrency.valueOf(161);
            }
            else if (TESTPATTERN25.equals(SYORIPTN)) {

                return BizCurrency.valueOf(162);
            }

            else if (TESTPATTERN32.equals(SYORIPTN)) {

                return BizCurrency.valueOf(68);
            }
            else if (TESTPATTERN33.equals(SYORIPTN)) {

                return BizCurrency.valueOf(69);
            }
            else if (TESTPATTERN34.equals(SYORIPTN)) {

                return BizCurrency.valueOf(70);
            }
            return BizCurrency.valueOf(0);
        }
        else {
            return super.getSaiteiP(pMp, pSyoriCTL, pMosKihon, pMosSyouhn, pSyouhnZokusei);
        }
    }

    @Override
    public boolean getChkhubigaitouflg() {
        if (caller == CheckSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        return super.getChkhubigaitouflg();
    }
}