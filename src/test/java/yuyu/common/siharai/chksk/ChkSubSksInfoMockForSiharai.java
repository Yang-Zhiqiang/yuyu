package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * {@link ChkSubSksInfo}のモッククラスです。<br />
 */
public class ChkSubSksInfoMockForSiharai extends ChkSubSksInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public void exec(C_InputShrhousiteiKbn pInputShrhousiteiKbn, String pBankCd, String pSitenCd, C_YokinKbn pYokinKbn,
        String pKouzaNo, C_Kzdou pKzdou, String pKzMeiginMkn, C_Tuukasyu pTuukasyu, String pSeikyuusyanmkn,
        C_SeikyuusyaKbn pSeikyuusyaKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;

            }
        }
        super.exec(pInputShrhousiteiKbn, pBankCd, pSitenCd, pYokinKbn,
            pKouzaNo, pKzdou, pKzMeiginMkn, pTuukasyu, pSeikyuusyanmkn, pSeikyuusyaKbn, pChkKekkaBeanLst);

    }
}