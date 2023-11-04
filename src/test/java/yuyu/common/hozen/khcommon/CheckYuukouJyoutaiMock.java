package yuyu.common.hozen.khcommon;

import yuyu.common.direct.dscommon.CheckDsKaiyakuTest_kaiyakukytChk;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckTest_checkTumitatekinIten;
import yuyu.def.classification.C_YuukoujyotaichkKbn;

/**
 * {@link CheckYuukouJyoutai}のモッククラスです<br />
 */
public class CheckYuukouJyoutaiMock extends CheckYuukouJyoutai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_YuukoujyotaichkKbn exec(KhozenCommonParam pKhCp, CheckYuukouJyoutaiExecUiBeanParam pUiBean) {

        if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_YuukoujyotaichkKbn.HUKA;
        } else if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_YuukoujyotaichkKbn.KA;
        }
        else if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_YuukoujyotaichkKbn.HUKA;
        } else if (caller == DsTumitatekinItenCheckTest_checkTumitatekinIten.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_YuukoujyotaichkKbn.KA;
        }

        return super.exec(pKhCp, pUiBean);
    }



















}
