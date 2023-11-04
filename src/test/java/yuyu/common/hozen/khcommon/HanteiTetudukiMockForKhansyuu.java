package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_SyorikahiKbn;

/**
 * {@link HanteiTetuduki}のモッククラスです<br />
 */
public class HanteiTetudukiMockForKhansyuu extends HanteiTetuduki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_SyorikahiKbn exec(KhozenCommonParam khozenCommonParam, String syono) {
        if (caller == CommonNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SyorikahiKbn.TYUUITRATKIKA;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SyorikahiKbn.SYORIKANOU;
            }
        }

        return super.exec(khozenCommonParam, syono);
    }
}
