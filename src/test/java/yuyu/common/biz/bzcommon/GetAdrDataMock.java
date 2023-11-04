package yuyu.common.biz.bzcommon;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosKihonTest_exec;
import yuyu.def.classification.C_ErrorKbn;


/**
 * {@link GetAdrData}のモッククラスです。<br />
 */
public class GetAdrDataMock extends GetAdrData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public void exec(String pYno) {

        if (caller == CheckTblMosKihonTest_exec.class) {
        }
        super.exec(pYno);
    }

    @Override
    public C_ErrorKbn getErrorKbn() {
        if (caller == CheckTblMosKihonTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        return C_ErrorKbn.OK;
    }
}