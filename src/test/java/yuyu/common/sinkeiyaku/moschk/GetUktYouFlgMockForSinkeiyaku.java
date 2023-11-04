package yuyu.common.sinkeiyaku.moschk;


/**
 * {@link GetUktYouFlg}のモッククラスです。<br />
 */
public class GetUktYouFlgMockForSinkeiyaku extends GetUktYouFlg {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean getFlgSbHnknknUkt() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }

        return super.getFlgSbHnknknUkt();
    }

    @Override
    public boolean getFlgSbUkt() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        return super.getFlgSbUkt();
    }

    @Override
    public boolean getFlgHhknDr() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        return super.getFlgHhknDr();
    }

    @Override
    public boolean getFlgNkUkt() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        return super.getFlgNkUkt();
    }

    @Override
    public boolean getFlgKzkTrkSrv() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return true;
        }


        return super.getFlgKzkTrkSrv();
    }

    @Override
    public boolean getFlgKykDr() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        return super.getFlgKykDr();
    }

    @Override
    public boolean getFlgTikShrknUkt() {
        if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckTblUketorininTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        return super.getFlgTikShrknUkt();
    }


    @Override
    public void exec(MosnaiCheckParam pMp) {
        if (caller == CheckTblUketorininTest_exec.class) {
        }
        else {
            super.exec(pMp);
        }
    }
}