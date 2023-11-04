package yuyu.common.hozen.khcommon;

import yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyounoTest_execPostForm;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;

/**
 * {@link SaibanCreditKessaiyouNo}のモッククラスです。<br />
 */
public class SaibanCreditKessaiyouNoForSinkeiyaku extends SaibanCreditKessaiyouNo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public String exec(C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn, String pCreditCardDbKey) {
        if (caller == HbSeihoWebCreditkessaiyounoTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "112233445566";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return Integer.toString(3/0);
            }
        }
        return super.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);
    }

}
