package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 業務共通 業務共通 指数取得<br />
 * {@link GetSisuuMock}のモッククラスです。<br />
 */
public class GetSisuuMockForSuuri extends GetSisuu {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public C_ErrorKbn exec(C_Sisuukbn pSisuukbn, BizDate pSisuushutokuymd, C_YouhiKbn pYouhiKbn) {
        if (SrSinkykSeirituKoumokuCommonSetTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pSisuukbn, pSisuushutokuymd, pYouhiKbn);
    }

    @Override
    public BizNumber getSisuu() {

        if (SrSinkykSeirituKoumokuCommonSetTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(3.1);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(3.1);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(3.1);
            }
        }
        return super.getSisuu();
    }

}