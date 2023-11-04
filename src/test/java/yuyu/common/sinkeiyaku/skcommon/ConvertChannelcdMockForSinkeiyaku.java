package yuyu.common.sinkeiyaku.skcommon;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_Channelcd;

/**
 * {@link ConvertChannelcd}のモッククラスです。<br />
 */
public class ConvertChannelcdMockForSinkeiyaku extends ConvertChannelcd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_Channelcd exec(C_Channelcd pChannelCd, String pOyadrtenCd) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_Channelcd.BLNK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_Channelcd.TIGIN;
            }
        }
        return super.exec(pChannelCd, pOyadrtenCd);
    }
}