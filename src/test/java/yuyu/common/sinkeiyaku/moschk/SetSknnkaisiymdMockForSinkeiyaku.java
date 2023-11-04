package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;

/**
 * {@link SetSknnkaisiymd}のモッククラスです。<br />
 */
public class SetSknnkaisiymdMockForSinkeiyaku extends SetSknnkaisiymd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SntkhouKbn pSntkhouKbn,
        BizDate                  pKktYmd,
        BizDate                  pMosYmd,
        BizDate                  pRsYmd,
        C_SknnkaisikitkhukaKbn   pSknnKaisikiTkHkKbn,
        BizDate                  pMosUkeYmd) {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20170425"));
                setKariSknnkaisiymd(BizDate.valueOf("20170424"));
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20160419"));
                setKariSknnkaisiymd(BizDate.valueOf("20160419"));
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20170417"));
                setKariSknnkaisiymd(BizDate.valueOf("20160401"));
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20170602"));
                setKariSknnkaisiymd(BizDate.valueOf("20160602"));
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20170902"));
                setKariSknnkaisiymd(BizDate.valueOf("20160902"));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                setSknnkaisiymd(BizDate.valueOf("20171002"));
                setKariSknnkaisiymd(BizDate.valueOf("20161002"));
            }
            else {
                super.exec(pSntkhouKbn, pKktYmd, pMosYmd, pRsYmd, pSknnKaisikiTkHkKbn, pMosUkeYmd);
            }
        }
        else {
            super.exec(pSntkhouKbn, pKktYmd, pMosYmd, pRsYmd, pSknnKaisikiTkHkKbn, pMosUkeYmd);
        }
    }

}