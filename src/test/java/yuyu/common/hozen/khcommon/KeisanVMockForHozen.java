package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;

/**
 * {@link KeisanV}のモッククラスです<br />
 */
public class KeisanVMockForHozen extends KeisanV {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency tumitateKin = null;

    @Override
    public C_ErrorKbn exec(
        BizDate pCalckijyunYmd,
        BizDateYM pCalckijyunYm,
        BizDate pKykymd,
        String pSyouhnCd,
        int pSyouhnsdNo,
        String pRyouritusdNo,
        BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHaraikomiKaisuu,
        C_Hhknsei pHhknSei,
        int pHhknNen,
        C_HknkknsmnKbn pHknKknSmnKbn,
        int pHknkkn,
        C_HrkkknsmnKbn pHrkkknsmnKbn,
        int pHrkkkn,
        BizCurrency pKihonS,
        int pKeikaNensuu,
        int pKkeikaMon,
        C_Tuukasyu pKeiyakuTuukasyu,
        BizCurrency pHokenryou,
        C_TyksenhokanhouKbn pTyksenhokanhouKbn,
        C_Kykjyoutai pKykjyoutai,
        int pDai1hknkkn) {

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == KeisanWItijiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanWHyojyunTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pHrkkkn == 0) {
                    tumitateKin = BizCurrency.valueOf(21345, BizCurrencyTypes.DOLLAR);
                }
                if (pHrkkkn == 1) {

                    tumitateKin = BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR);
                }
                if (pHrkkkn == 2) {

                    tumitateKin = BizCurrency.valueOf(42345, BizCurrencyTypes.DOLLAR);
                }
                if (pHrkkkn == 3) {

                    tumitateKin = BizCurrency.valueOf(51345, BizCurrencyTypes.DOLLAR);
                }
                return C_ErrorKbn.OK;
            }
        }

        	return super.exec(
            pCalckijyunYmd,
            pCalckijyunYm,
            pKykymd,
            pSyouhnCd,
            pSyouhnsdNo,
            pRyouritusdNo,
            pYoteiRiritu,
            pHaraikomiKaisuu,
            pHhknSei,
            pHhknNen,
            pHknKknSmnKbn,
            pHknkkn,
            pHrkkknsmnKbn,
            pHrkkkn,
            pKihonS,
            pKeikaNensuu,
            pKkeikaMon,
            pKeiyakuTuukasyu,
            pHokenryou,
            pTyksenhokanhouKbn,
            pKykjyoutai,
            pDai1hknkkn);
    }

    @Override
    public BizCurrency getV() {

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(200);
            }
        }

        if (caller == KeisanWItijiTest_exec.class ) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
        }

        if (caller == KeisanWHyojyunTest_exec.class ) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3657, BizCurrencyTypes.YEN);
            }
        }

        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return tumitateKin;
            }
        }

        return super.getV();
    }
}
