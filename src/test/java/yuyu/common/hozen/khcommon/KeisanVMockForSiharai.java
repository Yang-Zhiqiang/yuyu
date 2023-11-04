package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.siharai.sicommon.GetSibouymdWTest_exec;
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
public class KeisanVMockForSiharai extends KeisanV {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

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
        int pDai1hknkkn
        ) {

        if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
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
            pDai1hknkkn
            );
    }

    @Override
    public BizCurrency getV() {

        if (caller == GetSibouymdWTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN) ||TESTPATTERN2.equals(SYORIPTN)){
                return BizCurrency.valueOf(200);
            }
        }
        return super.getV();
    }
}
