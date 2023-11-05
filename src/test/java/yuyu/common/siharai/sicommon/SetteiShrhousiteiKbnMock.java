package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.chksk.ChkSubSksInfoTest_exec;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link SetteiShrhousiteiKbn}のモッククラスです。<br />
 */
public class SetteiShrhousiteiKbnMock extends SetteiShrhousiteiKbn {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ShrhousiteiKbn exec(C_InputShrhousiteiKbn pInputShrhousiteiKbn, C_Tuukasyu pTuukasyu ) {

        if (caller == ChkSubSksInfoTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.FB_YOKUJITU;
        }
        else if  (caller == ChkSubSksInfoTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.FB_2EIGYOUBI;
        }
        else if  (caller == SiSiharaiKingakuKeisanTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI;
        }
        else if  (caller == SiSiharaiKingakuKeisanTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.FB_YOKUJITU;
        }
        else if  (caller == SiSiharaiKingakuKeisanTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI;
        }
        else if  (caller == SiSiharaiKingakuKeisanTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return C_ShrhousiteiKbn.FB_2EIGYOUBI;
        }

        else {
            return  super.exec(pInputShrhousiteiKbn,pTuukasyu);

        }
    }

}