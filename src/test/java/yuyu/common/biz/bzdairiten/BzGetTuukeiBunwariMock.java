package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousinTest_exec;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiTest_exec;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * {@link BzGetTuukeiBunwari}のモッククラスです。<br />
 */
public class BzGetTuukeiBunwariMock extends BzGetTuukeiBunwari {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public C_ErrorKbn getErrorKbn() {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.getErrorKbn();
    }

    @Override
    public String getDrtencd1() {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            return "d010101";
        }

        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            return "";
        }

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return "1000";
            }
        }
        return super.getDrtencd1();
    }

    @Override
    public BizNumber getBuntanWariai1() {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            return BizNumber.valueOf(50);
        }

        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizNumber.valueOf(50);
        }

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizNumber.valueOf(10);
            }
        }
        return super.getBuntanWariai1();
    }

    @Override
    public String getDrtencd2() {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            return "d020202";
        }

        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            return "";
        }
        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return "2000";
            }
        }

        return super.getDrtencd2();
    }

    @Override
    public BizNumber getBuntanWariai2() {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            return BizNumber.valueOf(50);
        }

        else if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizNumber.valueOf(50);
        }

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizNumber.valueOf(20);
            }
        }
        return super.getBuntanWariai2();
    }

    @Override
    public void exec(String pDrtenCd1, String pOyaDrtenCd1, BizNumber pBuntanWariai1,
        String pDrtenCd2, String pOyaDrtenCd2, BizNumber pBuntanWariai2, BizDateYM pKijyunYm,
        C_DrtSyouhinSikibetuKbn pDrtSyouhinSikibetuKbn, C_Hrkkaisuu pHrkkaisuu, C_DiritenplannmKbn pDiritenplannmKbn) {

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            return;
        }

        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pDrtenCd1, pOyaDrtenCd1, pBuntanWariai1, pDrtenCd2, pOyaDrtenCd2, pBuntanWariai2, pKijyunYm,
            pDrtSyouhinSikibetuKbn, pHrkkaisuu, pDiritenplannmKbn);
    }
}