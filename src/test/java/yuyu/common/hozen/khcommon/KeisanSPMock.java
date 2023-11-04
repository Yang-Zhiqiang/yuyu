package yuyu.common.hozen.khcommon;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
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
public class KeisanSPMock  extends KeisanSP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static String flg = "0";

    private int callKaisuu = 1;

    public static int icount = 1;

    private BizCurrency hknRyou = null;

    private String msgId = "";

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
        if (caller == KeisanSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == KeisanSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN3.equals(SYORIPTN) && "0".equals(flg)) {
            flg = "1";
            return C_ErrorKbn.OK;
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN3.equals(SYORIPTN) && "1".equals(flg)) {
            flg = "2";
            return C_ErrorKbn.OK;
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN3.equals(SYORIPTN) && "2".equals(flg)) {
            flg = "0";
            return C_ErrorKbn.ERROR;
        }
        else if (caller == CheckTuusanTest_exec.class) {
            return C_ErrorKbn.OK;
        }
        else if (caller == CheckSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == CheckSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        } else if (caller == KeisanIkkatuPGkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {

                hknRyou = BizCurrency.valueOf(450);
                msgId = "EIC0001";
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN6.equals(SYORIPTN)) {


                if (icount == 1) {

                    hknRyou = BizCurrency.valueOf(3200);
                    icount=2;

                    return C_ErrorKbn.OK;

                }

                if (icount == 2) {

                    hknRyou = BizCurrency.valueOf(850);
                    icount = 1;
                    msgId = "EIC0001";
                    return C_ErrorKbn.ERROR;
                }
            }
            else {

                hknRyou = BizCurrency.valueOf(2250);

                return C_ErrorKbn.OK;

            }
        }
        return super.exec(pSyouhnCd, pRyouritusdNo,
            pYoteiRiritu, pHaraikomikaisuu,
            pHhknNen, pHhknSei,
            pHknkknsmnKbn, pHknkkn,
            pHrkkkn, pSdpd,
            pHknKingaku, pHknRyou, pKeiyakuTuukasyu,
            pKykjyoutai,
            pDai1hknkkn,
            pHrkkeiro);

    }

    @Override
    public BizCurrency getS() {
        if (caller == KeisanSPTest_exec.class) {
            return BizCurrency.valueOf(80);
        }
        else if (caller == CheckTuusanTest_exec.class) {
            return BizCurrency.valueOf(70);
        }
        return super.getS();
    }

    @Override
    public BizCurrency getP() {
        if (caller == KeisanSPTest_exec.class) {
            return BizCurrency.valueOf(80);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return BizCurrency.valueOf(666);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return BizCurrency.valueOf(50);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return BizCurrency.valueOf(50);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {

            return BizCurrency.valueOf(10000);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {

            return BizCurrency.valueOf(1000);
        }
        else if (caller == CheckTuusanTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {

            return BizCurrency.valueOf(10000);
        }
        else if (caller == CheckSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(10000);
        }

        return super.getP();
    }

}
