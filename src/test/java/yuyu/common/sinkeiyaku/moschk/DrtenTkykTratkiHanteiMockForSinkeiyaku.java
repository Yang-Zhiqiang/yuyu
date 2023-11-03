package yuyu.common.sinkeiyaku.moschk;

import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 代理店別特約取扱判定{@link DrtenTkykTratkiHantei}のモッククラスです。<br />
 */
public class DrtenTkykTratkiHanteiMockForSinkeiyaku extends DrtenTkykTratkiHantei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_TkykTratkiKbn targettkTratkiHantei(C_TargetTkHukaKanouKbn pTargetTkHukaKanouKbn,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.BLNK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAHISSU;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.BLNK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAHISSU;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.BLNK;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
        }

        return super.targettkTratkiHantei(pTargetTkHukaKanouKbn, pSkeijimuKbn, pOyadrtencd);
    }

    @Override
    public C_TkykTratkiKbn yennykntkTratkiHantei(String pSyouhncd, C_UmuKbn pPyennykntktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.BLNK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAHISSU;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
        }

        return super.yennykntkTratkiHantei(pSyouhncd, pPyennykntktekiumu, pSkeijimuKbn, pOyadrtencd);
    }

    @Override
    public C_TkykTratkiKbn gaikanykntkTratkiHantei(String pSyouhncd, C_UmuKbn pGaikanyuukintktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.BLNK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAKANOU;
            }
        }

        return super.gaikanykntkTratkiHantei(pSyouhncd, pGaikanyuukintktekiumu, pSkeijimuKbn, pOyadrtencd);
    }

    @Override
    public C_TkykTratkiKbn initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(String pSyouhncd, C_UmuKbn pSyksbyensitihsyutktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAHISSU;
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
        }

        if (caller == CheckTblMosSyouhinTest_exec5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.TRATKINASI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_TkykTratkiKbn.HUKAHISSU;
            }
        }
        return super.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(pSyouhncd, pSyksbyensitihsyutktekiumu,
            pSkeijimuKbn, pOyadrtencd);
    }


}
