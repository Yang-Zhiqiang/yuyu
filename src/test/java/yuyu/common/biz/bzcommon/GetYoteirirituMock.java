package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditSuiihyouTblNenkin2Test_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblNenkin2Test_exec;
import yuyu.common.hozen.khcommon.KeisanVHeijyunTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkin2Test_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHokenRyouYuukouKigenTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetYoteiriritu}のモッククラスです。<br />
 */
public class GetYoteirirituMock extends GetYoteiriritu {

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

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.OK;

        }

        else if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BizNumber yoteiriritu = BizNumber.valueOf(30);
                super.exec(pGetYoteirirituBean);

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.OK;
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == EditSyoukenTblNenkin2Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.OK;
        }

        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == WSuiihyouNenkin2Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
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

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.1);
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.2);
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return null;
            }

            return BizNumber.valueOf(0);
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.11);
            }
        }
        else if (caller == EditSyoukenTblNenkin2Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.35);
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.25);
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(0);
            }
        }
        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
            return BizNumber.valueOf(1.1);
        }

        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.2);
            }
        }
        else if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.35);
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.25);
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(0);
            }
        }
        else if (caller == WSuiihyouNenkin2Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.033);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(0);
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

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.2);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.4);
            }
            return BizNumber.valueOf(0);
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1);
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

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.6);
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.9);
            }
            return BizNumber.valueOf(0);
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1);
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
        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class) {
            if (TESTPATTERN9.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.7);
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.9);
            }
            return BizNumber.valueOf(0);
        }

        else if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1);
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