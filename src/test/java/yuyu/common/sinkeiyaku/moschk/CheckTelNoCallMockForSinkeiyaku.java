package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.classification.C_KouzokujkKbn;

/**
 * 電話番号チェック呼出し{@link CheckTelNoCall}のモッククラスです。<br />
 */
public class CheckTelNoCallMockForSinkeiyaku extends CheckTelNoCall {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void execHhkn(MosnaiCheckParam pMp) {
        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }

        super.execHhkn(pMp);
    }

    @Override
    public void execTuusin(MosnaiCheckParam pMp) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }

        super.execTuusin(pMp);
    }

    @Override
    public void execDainiTuusin(MosnaiCheckParam pMp) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            return;
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            return;
        }

        super.execDainiTuusin(pMp);
    }
}

