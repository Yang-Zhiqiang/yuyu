package yuyu.common.biz.kaikei;

import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 業務コード取得モッククラス<br />
 * {@link BzGyoumuCdSyutoku}のモッククラスです。<br />
 */
public class BzGyoumuCdSyutokuMock extends BzGyoumuCdSyutoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getDenGyoumuCd(C_ShrhousiteiKbn pShrhousiteiKbn, String pSyoricd, String pSyouhncd,
        Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, C_TantouCdKbn pTantouCd) {
        if (caller == BzDenpyouDataSksTest_execSk.class && SYORIPTN == TESTPATTERN1
            || (caller == BzDenpyouDataSksTest_execKh.class && SYORIPTN == TESTPATTERN1)
            || (caller == BzDenpyouDataSksTest_execSi.class && SYORIPTN == TESTPATTERN1)) {
            return C_Gyoumucd.BLNK.getValue();
        } else if (caller == BzDenpyouDataSksTest_execSk.class && SYORIPTN == TESTPATTERN2
            || (caller == BzDenpyouDataSksTest_execKh.class && SYORIPTN == TESTPATTERN2)
            || (caller == BzDenpyouDataSksTest_execSi.class && SYORIPTN == TESTPATTERN2)) {
            return C_Gyoumucd.GK_YENSOUKIN_SK.getValue();
        }
        return super.getDenGyoumuCd(pShrhousiteiKbn, pSyoricd, pSyouhncd, pSyouhnsdno, pTuukasyu, pTantouCd);
    }

    @Override
    public C_Gkgyoumucd changeGkGyoumuCd(String pDengyoumucd) {
        if (caller == BzGkfbSoukinDataSksTest_execSk.class && SYORIPTN == TESTPATTERN1
            || (caller == BzGkfbSoukinDataSksTest_execKh.class && SYORIPTN == TESTPATTERN1)
            || (caller == BzGkfbSoukinDataSksTest_execSi.class && SYORIPTN == TESTPATTERN1)) {
            return C_Gkgyoumucd.GK_GKSOUKIN_SK;
        } else if (caller == BzGkfbSoukinDataSksTest_execSk.class && SYORIPTN == TESTPATTERN2
            || (caller == BzGkfbSoukinDataSksTest_execKh.class && SYORIPTN == TESTPATTERN2)
            || (caller == BzGkfbSoukinDataSksTest_execSi.class && SYORIPTN == TESTPATTERN2)) {
            return C_Gkgyoumucd.BLNK;
        }
        return super.changeGkGyoumuCd(pDengyoumucd);
    }

    @Override
    public C_Gyoumucd changeYkGyoumuCd(String pDengyoumucd) {
        if (caller == BzFbSoukinDataSksTest_execKh.class && SYORIPTN == TESTPATTERN1
            || (caller == BzFbSoukinDataSksTest_execSi.class && SYORIPTN == TESTPATTERN1)
            || (caller == BzFbSoukinDataSksTest_execSk.class && SYORIPTN == TESTPATTERN1)) {
            return C_Gyoumucd.GK_YENSOUKIN_SK;
        } else if (caller == BzFbSoukinDataSksTest_execKh.class && SYORIPTN == TESTPATTERN2
            || (caller == BzFbSoukinDataSksTest_execSi.class && SYORIPTN == TESTPATTERN2)
            || (caller == BzFbSoukinDataSksTest_execSk.class && SYORIPTN == TESTPATTERN2)) {
            return C_Gyoumucd.BLNK;
        }
        return super.changeYkGyoumuCd(pDengyoumucd);
    }
}