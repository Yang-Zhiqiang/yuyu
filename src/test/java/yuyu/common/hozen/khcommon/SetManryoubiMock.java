package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_KknsmnKbn;

/**
 * {@link SetManryoubi}のモッククラスです。<br />
 */
public class SetManryoubiMock extends SetManryoubi{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public BizDate exec(BizDate pKykYmd, int pHhknNen, int pKikan, C_KknsmnKbn pKknsmnKbn) {
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf(20190101);
            }
            else if(TESTPATTERN2.equals(SYORIPTN)) {
                return null;
            }

        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if(C_KknsmnKbn.NEN.eq(pKknsmnKbn)){
                    return BizDate.valueOf(20190311);
                }
                return BizDate.valueOf(20190312);
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if(C_KknsmnKbn.NEN.eq(pKknsmnKbn)){
                    return BizDate.valueOf(20200227);
                }
                return BizDate.valueOf(20220301);
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf(20190312);
            }
        }

        return super.exec(pKykYmd, pHhknNen, pKikan, pKknsmnKbn);

    }

}
