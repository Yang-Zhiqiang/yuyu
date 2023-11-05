package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.CheckDsKaiyakuTest_kaiyakukytChk;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckTest_checkTumitatekinIten;
import yuyu.def.classification.C_SyorikahiKbn;

/**
 * {@link HanteiTetuduki}のモッククラスです<br />
 */
public class HanteiTetudukiMock extends HanteiTetuduki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_SyorikahiKbn exec(KhozenCommonParam khozenCommonParam, String syono) {


        if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_SyorikahiKbn.SYORIHUKA;
        } else if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_SyorikahiKbn.SYORIKANOU;
        }
        else if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_SyorikahiKbn.SYORIHUKA;
        } else if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_SyorikahiKbn.SYORIKANOU;
        }
        else if (caller == CommonNyuukinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_SyorikahiKbn.TYUUITRATKIKA;
        } else if (caller == CommonNyuukinTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_SyorikahiKbn.SYORIKANOU;
        }

        return super.exec(khozenCommonParam, syono);
    }
}
