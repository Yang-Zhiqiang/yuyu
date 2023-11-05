package yuyu.common.biz.bznayose;

import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link BzTrksTjtIdouNaiyouSakujyo}のモッククラスです。<br />
 */
public class BzTrksTjtIdouNaiyouSakujyoMock extends BzTrksTjtIdouNaiyouSakujyo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public C_ErrorKbn exec(BzTrksTjtIdouNaiyouSakujyoBean pBzTrksTjtIdouNaiyouSakujyoBean) {

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (caller == PALKykKousinTorikesiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)){

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }
        if (caller == PALKykKousinTorikesiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)){

            errorKbn = C_ErrorKbn.OK;

            return errorKbn;
        }

        return super.exec(pBzTrksTjtIdouNaiyouSakujyoBean);
    }
}
