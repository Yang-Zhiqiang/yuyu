package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import yuyu.def.db.entity.HT_Uketorinin;

/**
 * {@link CheckNkUktKbn}のモッククラスです。<br />
 */
public class CheckNkUktKbnMockForSinkeiyaku extends CheckNkUktKbn {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMP, List<HT_Uketorinin> pUketorininLst) {

        if (caller == CheckTblUketorininTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.exec(pMP, pUketorininLst);
    }

}
