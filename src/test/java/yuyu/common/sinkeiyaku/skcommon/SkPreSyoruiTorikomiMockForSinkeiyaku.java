package yuyu.common.sinkeiyaku.skcommon;

import yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosnoTest_execPostForm;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link SkPreSyoruiTorikomi}のモッククラスです。<br />
 */
public class SkPreSyoruiTorikomiMockForSinkeiyaku extends SkPreSyoruiTorikomi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String[] sinkykSyoruiTorikomi(String pMosNo,
        C_SyoruiCdKbn[] pSyoruiCds,
        C_SkeijimuKbn pSkeijimuKbn,
        C_HknsyuruiNo pHknsyuruiNo,
        C_MosUketukeKbn pMosUketukeKbn,
        String pDrtenCd) {

        if (caller == HbSeihoWebMosnoTest_execPostForm.class) {
            String[] qrCodes = null;

            if (TESTPATTERN1.equals(SYORIPTN)) {
                qrCodes = new String[1];
                qrCodes[0] = "mos0032e5vc0hcg3fvchs";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                qrCodes = new String[1];
                qrCodes[0] = "mos0042e5vehw8yryhwcg";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                qrCodes = new String[1];
                qrCodes[0] = "mos0042e5vehw8yryhwch";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                qrCodes = new String[1];
                qrCodes[0] = "mos0042e5vehw8yryhwci";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                qrCodes = new String[4];
                qrCodes[0] = "mos0032e5vc0hcg3fvchsmos0032e5vc0hcg3fvchs";
                qrCodes[1] = "mos0042e5vehw8yryhwcg";
                qrCodes[2] = "mos0042e5vehw8yryhwch";
                qrCodes[3] = "mos0042e5vehw8yryhwci";
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                qrCodes = new String[4];
                qrCodes[0] = "mos0032e5vc0hcg3fvchs";
                qrCodes[1] = "mos0042e5vehw8yryhwcg";
                qrCodes[2] = "mos0042e5vehw8yryhwch";
                qrCodes[3] = "mos0042e5vehw8yryhwci";
            }
            else {
                qrCodes = new String[1];
                qrCodes[2] = "mos0032e5vc0hcg3fvchs";
                return qrCodes;
            }
            return qrCodes;
        }

        return super.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds,
            pSkeijimuKbn, pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);
    }
}