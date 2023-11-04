package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetYoteiriritu}のモッククラスです。<br />
 */
public class GetYoteirirituMockForSinkeiyaku extends GetYoteiriritu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(GetYoteirirituBean pGetYoteirirituBean) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pGetYoteirirituBean);
    }

    @Override
    public BizNumber getYoteiriritu() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizNumber.valueOf(0);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizNumber.valueOf(1);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizNumber.valueOf(1.1);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizNumber.valueOf(4);
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {
                return BizNumber.valueOf(9);
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {
                return BizNumber.valueOf(6);
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return BizNumber.valueOf(7);
            }
        }

        return super.getYoteiriritu();
    }

    @Override
    public BizNumber getTumitateriritu() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizNumber.valueOf(0);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizNumber.valueOf(2.123);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizNumber.valueOf(3.456);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizNumber.valueOf(4.567);
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {
                return BizNumber.valueOf(5.678);
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {
                return BizNumber.valueOf(6.789);
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return BizNumber.valueOf(7.891);
            }
        }

        return super.getTumitateriritu();
    }

    @Override
    public BizNumber getTmttknzoukaritujygn() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizNumber.valueOf(0);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizNumber.valueOf(2.123);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizNumber.valueOf(3.456);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizNumber.valueOf(4.567);
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {
                return BizNumber.valueOf(5.678);
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {
                return BizNumber.valueOf(6.789);
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return BizNumber.valueOf(7.891);
            }
        }

        return super.getTmttknzoukaritujygn();
    }

    @Override
    public BizNumber getSetteibairitu() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizNumber.valueOf(0);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return BizNumber.valueOf(2.23);
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                return BizNumber.valueOf(3.45);
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizNumber.valueOf(4.56);
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {
                return BizNumber.valueOf(5.67);
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {
                return BizNumber.valueOf(6.78);
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {
                return BizNumber.valueOf(7.89);
            }
        }

        return super.getSetteibairitu();
    }

    @Override
    public BizNumber getLoadinghnkgtumitateriritu() {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (SYORIPTN.equals(TESTPATTERN4)) {
                return BizNumber.valueOf(2);
            }
            return BizNumber.valueOf(1.5);
        }
        return super.getLoadinghnkgtumitateriritu();
    }
}