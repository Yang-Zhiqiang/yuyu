package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;

/**
 * {@link BzChkBsYuukou}のモッククラスです。<br />
 */
public class BzChkBsYuukouMock extends BzChkBsYuukou {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public Boolean exec(String pBosyuuCd, BizDate pKijyunYmd) {

        if (caller == BzChkBsYuukouHengakuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return false;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
        }

        else if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return false;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
        }

        return super.exec(pBosyuuCd, pKijyunYmd);
    }


}