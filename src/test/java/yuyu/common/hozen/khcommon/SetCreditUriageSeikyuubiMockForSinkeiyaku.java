package yuyu.common.hozen.khcommon;

import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;
import jp.co.slcs.swak.date.BizDate;

/**
 * クレカ売上請求日設定のモッククラスです。<br />
 */
public class SetCreditUriageSeikyuubiMockForSinkeiyaku extends SetCreditUriageSeikyuubi{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int kaisu = 0;

    @Override
    public BizDate getJikaiUrsktysytbi() {

        if (caller == CheckNyuukinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181121");
                }
                return BizDate.valueOf("20181121");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181021");
                }
                return BizDate.valueOf("20190722");
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181021");
                }
                return BizDate.valueOf("20180522");
            }
        }

        return super.getJikaiUrsktysytbi();
    }

}
