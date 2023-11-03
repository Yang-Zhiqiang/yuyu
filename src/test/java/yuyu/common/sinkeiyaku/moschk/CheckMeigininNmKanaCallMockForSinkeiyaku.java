package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.classification.C_KouzokujkKbn;

/**
 * カナ名義人チェック呼出し{@link CheckMeigininNmKanaCall}のモッククラスです。<br />
 */
public class CheckMeigininNmKanaCallMockForSinkeiyaku extends CheckMeigininNmKanaCall {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean execKyk(MosnaiCheckParam pMp) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return true;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return true;
            }
        }

        return super.execKyk(pMp);
    }

    @Override
    public boolean execHhkn(MosnaiCheckParam pMp) {


        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return true;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return true;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return true;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return true;
            }
        }

        return super.execHhkn(pMp);
    }
}
