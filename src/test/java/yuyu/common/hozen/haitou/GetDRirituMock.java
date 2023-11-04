package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.siharai.chksk.ChkSubDTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetDRiritu}のモッククラスです。<br />
 */
public class GetDRirituMock extends GetDRiritu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizDate pCalckijyunfromymd, BizDate pCalckijyuntoymd) {

        if (ChkSubDTest_exec.class == caller  ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDGanrikinTest_exec1.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }else if (KeisanDGanrikinTest_exec2.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }else if (KeisanDGanrikinTest_exec3.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pCalckijyunfromymd, pCalckijyuntoymd);
    }

    @Override
    public BizNumber getDRiritu() {

        if (ChkSubDTest_exec.class == caller  ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.1);
            }
        }

        if (KeisanDGanrikinTest_exec1.class == caller  ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizNumber.valueOf(0.1);
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizNumber.valueOf(1.6);
            }
        }
        return super.getDRiritu();
    }
}
