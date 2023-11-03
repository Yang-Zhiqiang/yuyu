package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.suuri.srcommon.SrSinkykSeirituKoumokuCommonSetTest_exec;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link GetKawaseRate}のモッククラスです。<br />
 */
public class GetKawaseRateMockForSuuri extends GetKawaseRate {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

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

    @Override
    public C_ErrorKbn exec(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn, C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn, C_KawasetsryKbn pKawasetsryKbn,
        C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
            pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
    }

    @Override
    public BizNumber getKawaserate() {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return BizNumber.valueOf(1);
        }

        return super.getKawaserate();
    }

    @Override
    public BizDate getKwsrateKjYmd() {

        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class) {
            return BizDate.valueOf("20160104");
        }

        return super.getKwsrateKjYmd();
    }
}
