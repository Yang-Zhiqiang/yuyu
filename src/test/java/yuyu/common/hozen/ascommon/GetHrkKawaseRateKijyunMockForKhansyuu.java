package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkTest_exec;
import yuyu.common.hozen.khcommon.SetKjsmyouZennouInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 払込用為替レート基準日取得{@link GetHrkKawaseRateKijyun}のモッククラスです。<br />
 */
public class GetHrkKawaseRateKijyunMockForKhansyuu extends GetHrkKawaseRateKijyun {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    private BizDate kawaseRateKijyun;

    @Override
    public C_ErrorKbn exec(C_NyknaiyouKbn pNyknaiyouKbn, C_Nykkeiro pNykkeiro, BizDate pRsymd, BizDateYM
        pJyutoustartym,Integer pJyuutounensuu,Integer pJyuutoutukisuu,C_Hrkkaisuu pHrkkaisuu) {

        if (caller == SetKjsmyouZennouInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN) || TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pNyknaiyouKbn, pNykkeiro, pRsymd,pJyutoustartym,pJyuutounensuu,pJyuutoutukisuu,pHrkkaisuu);
    }

    @Override
    public BizDate getKawaseRateKijyun() {

        if (caller == SetKjsmyouZennouInfoTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                kawaseRateKijyun = BizDate.valueOf(20200817);
                return kawaseRateKijyun;
            }
        }
        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                kawaseRateKijyun = BizDate.valueOf(20200826);
                return kawaseRateKijyun;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN6.equals(SYORIPTN)) {
                kawaseRateKijyun = BizDate.valueOf(20201215);
                return kawaseRateKijyun;
            }
        }

        return super.getKawaseRateKijyun();
    }

    @Override
    public List<String> getErrorCd() {

        if (caller == KeisanTukiRsgakuTest_exec1.class) {
            List<String> errorCd = new ArrayList<String>();

            if (TESTPATTERN1.equals(SYORIPTN)) {

                errorCd.add(KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR);
                return errorCd;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {
            List<String> errorCd = new ArrayList<String>();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);
                return errorCd;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_NYKKEIRO_CHKERROR);
                return errorCd;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR);
                return errorCd;
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_NYKNAIYOUKBN_CHKERROR);
                return errorCd;
            } else if (TESTPATTERN5.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR);
                return errorCd;
            }
        }

        return super.getErrorCd();
    }

    @Override
    public String getErrorRiyuu() {

        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {


            if (TESTPATTERN1.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_NYKKEIRO_CHKERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_NYKNAIYOUKBN_CHKERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR;
            }
        }
        return super.getErrorRiyuu();
    }
}
