package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.ascommon.KeisanHrhnNewHrkpTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * SP計算{@link KeisanSP}のモッククラスです。<br />
 */
public class KeisanSPMockForKhansyuu  extends KeisanSP {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private int callKaisuu = 1;

    private BizCurrency hknRyou = null;

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

        if (caller == KeisanHrhnNewHrkpTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                hknRyou = BizCurrency.valueOf(450);
                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                hknRyou = null;
                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                if (callKaisuu == 1) {

                    hknRyou = BizCurrency.valueOf(3200);
                    callKaisuu++;

                    return C_ErrorKbn.OK;

                }

                if (callKaisuu == 2) {

                    hknRyou = BizCurrency.valueOf(850);
                    callKaisuu = 1;

                    return C_ErrorKbn.OK;
                }
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                if (callKaisuu == 1) {

                    hknRyou = BizCurrency.valueOf(3200);
                    callKaisuu++;

                    return C_ErrorKbn.OK;
                }

                if (callKaisuu == 2) {

                    hknRyou = BizCurrency.valueOf(230);
                    callKaisuu++;

                    return C_ErrorKbn.OK;
                }
                if (callKaisuu == 3) {

                    hknRyou = BizCurrency.valueOf(340);
                    callKaisuu++;

                    return C_ErrorKbn.OK;
                }
                if (callKaisuu == 4) {

                    hknRyou = BizCurrency.valueOf(460);
                    callKaisuu = 1;

                    return C_ErrorKbn.OK;
                }
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {

                if (callKaisuu == 1) {

                    hknRyou = BizCurrency.valueOf(3200);
                    callKaisuu++;

                    return C_ErrorKbn.OK;
                }

                if (callKaisuu == 2) {

                    hknRyou = BizCurrency.valueOf(230);
                    callKaisuu++;

                    return C_ErrorKbn.OK;
                }
                if (callKaisuu == 3) {

                    hknRyou = null;
                    return C_ErrorKbn.ERROR;
                }
            }

            return C_ErrorKbn.ERROR;
        }

        return super.exec(pSyouhnCd, pRyouritusdNo,
            pYoteiRiritu, pHaraikomikaisuu,
            pHhknNen, pHhknSei,
            pHknkknsmnKbn, pHknkkn,
            pHrkkkn, pSdpd,
            pHknKingaku, pHknRyou, pKeiyakuTuukasyu,
            pKykjyoutai, pDai1hknkkn, pHrkkeiro);
    }

    @Override
    public BizCurrency getP() {

        if(caller == KeisanHrhnNewHrkpTest_exec.class){
            return hknRyou;
        }

        return super.getP();
    }
}
