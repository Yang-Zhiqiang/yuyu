package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.hozen.khcommon.KeisanWExtTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetSjkkktyouseiyouriritu}のモッククラスです<br />
 */
public class GetSjkkktyouseiyourirituMock extends GetSjkkktyouseiyouriritu {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizNumber sjkkktyouseiyouriritu;

    @Override
    public BizNumber getSjkkktyouseiyouriritu() {
        if (caller == KeisanWExtTest_exec.class) {
            return sjkkktyouseiyouriritu;
        }
        else if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            return sjkkktyouseiyouriritu;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            return sjkkktyouseiyouriritu;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return sjkkktyouseiyouriritu;
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return sjkkktyouseiyouriritu;
        }

        return super.getSjkkktyouseiyouriritu();
    }

    @Override
    public C_ErrorKbn exec(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {
        if (caller == KeisanWExtTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = null;
            return C_ErrorKbn.ERROR;
        } else if (caller == KeisanWExtTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(5.1234);
            return C_ErrorKbn.OK;
        }
        else if (caller == SetHosyouTest_exec.class) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(8.8);
            return C_ErrorKbn.OK;
        }
        else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(1);
            return C_ErrorKbn.OK;
        } else if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = null;
            return C_ErrorKbn.ERROR;

        }
        else {
            return super.exec(pGetSjkkktyouseiyourirituBean);
        }
    }

    @Override
    public C_ErrorKbn execKykji(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(0.125);
            return C_ErrorKbn.OK;
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {

            pGetSjkkktyouseiyourirituBean.setSknnkaisiymd(BizDate.valueOf("20181255"));
            pGetSjkkktyouseiyourirituBean.setKykymd(BizDate.valueOf(""));
            return super.execKykji(pGetSjkkktyouseiyourirituBean);
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN1.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(0.125);
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN3.equals(SYORIPTN)) {
            sjkkktyouseiyouriritu = BizNumber.valueOf(-0.5);
            return C_ErrorKbn.OK;
        }
        return super.execKykji(pGetSjkkktyouseiyourirituBean);
    }
}
