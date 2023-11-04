package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetSjkkktyouseiyouriritu}のモッククラスです<br />
 */
public class GetSjkkktyouseiyourirituMockForSuuri extends GetSjkkktyouseiyouriritu {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizNumber sjkkktyouseiyouriritu;

    @Override
    public BizNumber getSjkkktyouseiyouriritu() {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return sjkkktyouseiyouriritu;
        }

        return super.getSjkkktyouseiyouriritu();
    }

    @Override
    public C_ErrorKbn exec(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                sjkkktyouseiyouriritu = BizNumber.valueOf(1);
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                sjkkktyouseiyouriritu = null;
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pGetSjkkktyouseiyourirituBean);
    }

}
