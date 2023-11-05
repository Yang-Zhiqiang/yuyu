package yuyu.common.sinkeiyaku.skcommon;

import yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosnoTest_execPostForm;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * {@link MousikomiNoUtil}のモッククラスです。<br />
 */
public class MousikomiNoUtilMockForSinkeiyaku extends MousikomiNoUtil {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getMosNo(C_SkeijimuKbn pSkeiJimuKbn, C_MosUketukeKbn pMosUketukeKbn, String pSousasyaCd) {

        if (caller == HbSeihoWebMosnoTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "970001111";
            }
        }

        return super.getMosNo(pSkeiJimuKbn, pMosUketukeKbn, pSousasyaCd);
    }
}