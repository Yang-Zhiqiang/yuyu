package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.classification.C_Znnkaisuukekka;

/**
 * {@link HanteizennouKaisuu}のモッククラスです。<br />
 */
public class HanteiZennouKaisuuMockForSinkeiyaku extends HanteiZennouKaisuu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_Znnkaisuukekka exec(MosnaiCheckParam pMp) {
        if (caller == CheckZennouKanrenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.OVER;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.TKOVER;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.ITIBU;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.ZENKI_ARI_HUITTI;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.TKZENKI_ARI_HUITTI;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.ZENKI_NASI_ITTI;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.TKZENKI_NASI_ITTI;
            }
        }
        if (caller == HanteiLINCTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.ZENKI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.OVER;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.TKOVER;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_Znnkaisuukekka.ITIBU;
            }
        }

        return super.exec(pMp);

    }
}