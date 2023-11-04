package yuyu.common.sinkeiyaku.skcommon;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckYakkanJyuryouHouhouTest_exec;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * {@link GetSkChannelInfo}のモッククラスです。<br />
 */
public class GetSkChannelInfoMockForSinkeiyaku extends GetSkChannelInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;
    @Override
    public C_SkeijimuKbn getSkeiJimuKbn() {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_SkeijimuKbn.SMBC;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_SkeijimuKbn.SMTB;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_SkeijimuKbn.NIHONYUUBIN;
            }
            return C_SkeijimuKbn.SMBC;
        }

        return super.getSkeiJimuKbn();
    }
    @Override
    public C_AisyoumeiChannelKbn getAisyoumeiChannelKbn() {

        if (caller == CheckYakkanJyuryouHouhouTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_AisyoumeiChannelKbn.SMBC;
            }

        }

        return super.getAisyoumeiChannelKbn();
    }
    @Override
    public void exec(C_Channelcd pChannelCd,
        String pDairitenCd) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            return;
        }

        super.exec(pChannelCd, pDairitenCd);
    }
}
