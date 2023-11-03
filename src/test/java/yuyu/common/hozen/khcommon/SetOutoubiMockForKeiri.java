package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.kaikei.BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * 直前直後応当日設定のモッククラスです。<br />
 */
public class SetOutoubiMockForKeiri extends SetOutoubi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDate exec(C_TykzentykgoKbn pTykzenTykgoKbn, BizDate pKijyunYmd,
        C_Hrkkaisuu pHhrkkaisuu, BizDate pHanteiYmd) {

        if (caller == BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20190101");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20160103");
            }
        }
        return super.exec(pTykzenTykgoKbn, pKijyunYmd, pHhrkkaisuu, pHanteiYmd);
    }
}
