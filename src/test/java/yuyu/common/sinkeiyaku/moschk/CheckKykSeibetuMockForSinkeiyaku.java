package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.classification.C_KouzokujkKbn;

/**
 * 契約者性別チェック{@link CheckKykSeibetu}のモッククラスです。<br />
 */
public class CheckKykSeibetuMockForSinkeiyaku extends CheckKykSeibetu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp) {

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

        super.exec(pMp);
    }
}