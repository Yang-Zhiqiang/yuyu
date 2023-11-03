package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec2;
import yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanSP}のモッククラスです。<br />
 */
public class KeisanSPMockForSinkeiyaku extends KeisanSP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

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

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN26 = "26";

    public static final String TESTPATTERN27 = "27";

    public static final String TESTPATTERN28 = "28";

    public static String flg = "0";

    public static int icount = 1;

    public static int icount9 = 1;


    public static int icount10 = 1;

    public static int icount12 = 1;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHaraikomikaisuu,
        int pHhknNen,
        C_Hhknsei pHhknSei,
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pHknkkn,
        int pHrkkkn,
        C_Sdpd pSdpd,
        BizCurrency pHknKingaku,
        BizCurrency pHknRyou,
        C_Tuukasyu pKeiyakuTuukasyu,
        C_Kykjyoutai pKykjyoutai,
        int pDai1hknkkn,
        C_Hrkkeiro pHrkkeiro) {
        if (caller == KeisanSPTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return C_ErrorKbn.ERROR;
            }

            if(TESTPATTERN2.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                icount9 += 1;
                if ( icount9 == 3) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                icount10 += 1;
                if ( icount10 == 4) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN12.equals(SYORIPTN)) {
                icount12 += 1;
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CheckTuusanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) && "0".equals(flg)) {
                flg = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) && "1".equals(flg)) {
                flg = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) && "2".equals(flg)) {
                flg = "0";
                return C_ErrorKbn.ERROR;
            }else {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CheckTuusanTest_exec2.class) {
            if (SYORIPTN.equals(TESTPATTERN2)) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN8)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN19)) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN.equals(TESTPATTERN20)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN21)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN26)) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN.equals(TESTPATTERN27)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN28)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyouhnCd, pRyouritusdNo, pYoteiRiritu, pHaraikomikaisuu, pHhknNen, pHhknSei, pHknkknsmnKbn,
            pHknkkn, pHrkkkn, pSdpd, pHknKingaku, pHknRyou, pKeiyakuTuukasyu, pKykjyoutai, pDai1hknkkn, pHrkkeiro);

    }

    @Override
    public BizCurrency getS() {
        if (caller == KeisanSPTest_exec.class) {
            return BizCurrency.valueOf(80);
        }
        else if (caller == CheckTuusanTest_exec.class) {
            return BizCurrency.valueOf(70);
        }
        else if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN10.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5006, BizCurrencyTypes.DOLLAR);
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5011, BizCurrencyTypes.DOLLAR);
            }
            if (TESTPATTERN12.equals(SYORIPTN)) {
                if ( icount12 == 4) {
                    return BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR);
                }
                return BizCurrency.valueOf(4119, BizCurrencyTypes.DOLLAR);
            }
        }
        else if (caller == CheckTuusanTest_exec2.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN20.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN21.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN27.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN28.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8, BizCurrencyTypes.YEN);
            }
        }
        return super.getS();
    }

    @Override
    public BizCurrency getP() {
        if (caller == KeisanSPTest_exec.class) {
            return BizCurrency.valueOf(80);
        }
        else if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4119, BizCurrencyTypes.DOLLAR);
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4119, BizCurrencyTypes.DOLLAR);
            }
            if (TESTPATTERN12.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4119, BizCurrencyTypes.DOLLAR);
            }
        }
        else if (caller == CheckTuusanTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(666);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }

        }
        return super.getP();
    }

    @Override
    public BizNumber getPRate() {

        if (caller == KeisanSPTest_exec.class) {
            return BizNumber.valueOf(1.23);
        }
        return super.getPRate();
    }

    @Override
    public BizNumber getPSRate() {

        if (caller == KeisanSPTest_exec.class) {
            return BizNumber.valueOf(2.34);
        }
        return super.getPSRate();
    }

    @Override
    public BizNumber getHrbtJyousu() {

        if (caller == KeisanSPTest_exec.class) {
            return BizNumber.valueOf(3.45);
        }
        return super.getHrbtJyousu();
    }
}
