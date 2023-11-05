package yuyu.common.biz.kaikei;

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 業務コード取得モッククラス<br />
 * {@link BzGyoumuCdSyutoku}のモッククラスです。<br />
 */
public class BzGyoumuCdSyutokuMockForKeiri extends BzGyoumuCdSyutoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getDenGyoumuCd(C_ShrhousiteiKbn pShrhousiteiKbn, String pSyoricd, String pSyouhncd,
        Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, C_TantouCdKbn pTantouCdKbn) {
        if (caller == BzDenpyouDataSksTest_execSk.class
            || caller == BzDenpyouDataSksTest_execKh.class
            || caller == BzDenpyouDataSksTest_execSi.class) {

            if (SYORIPTN == TESTPATTERN1) {
                return C_Gyoumucd.BLNK.getValue();
            } else if (SYORIPTN == TESTPATTERN2) {
                return C_Gyoumucd.GK_YENSOUKIN_SK.getValue();
            }
        }
        return super.getDenGyoumuCd(pShrhousiteiKbn, pSyoricd, pSyouhncd, pSyouhnsdno, pTuukasyu, pTantouCdKbn);
    }

}