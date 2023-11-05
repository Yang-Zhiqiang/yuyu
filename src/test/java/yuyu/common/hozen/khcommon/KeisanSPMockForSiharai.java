package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.siharai.sicommon.SiCalcKihrkmpstgkTest_exec;
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
public class KeisanSPMockForSiharai extends KeisanSP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

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

        if (caller == SiCalcKihrkmpstgkTest_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                return C_ErrorKbn.ERROR;
            }

            if(TESTPATTERN2.equals(SYORIPTN)){

                return C_ErrorKbn.OK;
            }
        }
        return super.exec(
            pSyouhnCd, pRyouritusdNo, pYoteiRiritu, pHaraikomikaisuu, pHhknNen, pHhknSei, pHknkknsmnKbn, pHknkkn,
            pHrkkkn, pSdpd, pHknKingaku, pHknRyou, pKeiyakuTuukasyu, pKykjyoutai, pDai1hknkkn, pHrkkeiro);

    }

    @Override
    public BizCurrency getP() {

        if (caller == SiCalcKihrkmpstgkTest_exec.class) {
            return BizCurrency.valueOf(100);
        }
        return super.getP();
    }

}
