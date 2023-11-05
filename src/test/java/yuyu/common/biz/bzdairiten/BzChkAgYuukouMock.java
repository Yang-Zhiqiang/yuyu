package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 業務共通 代理店 代理店有効性チェックのモッククラスです。<br />
 */
public class BzChkAgYuukouMock extends BzChkAgYuukou {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    private C_ErrorKbn errorKbn = C_ErrorKbn.OK;

    @Override
    public Boolean exec(String pDrtenCd, BizDate pKijyunYmd) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return false;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return true;
            }
        }

        return super.exec(pDrtenCd, pKijyunYmd);
    }


}