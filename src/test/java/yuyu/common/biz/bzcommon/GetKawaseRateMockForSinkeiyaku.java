package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link GetKawaseRate}のモッククラスです。<br />
 */
public class GetKawaseRateMockForSinkeiyaku extends GetKawaseRate {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";


    @Override
    public C_ErrorKbn exec(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn, C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn, C_KawasetsryKbn pKawasetsryKbn,
        C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        return super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
            pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
    }

    @Override
    public C_ErrorKbn execFstPNyuukin(BizDate pRyosyuymd, C_Tuukasyu pKyktuuka, C_Tuukasyu pHrktuuka,
        C_YouhiKbn pZenEigyoubiKsSyutokuYouhi, C_Hrkkaisuu pHrkkaisuu, C_SysKbn pSysKbn,
        C_UmuKbn pZennouMousideumu,  C_IkkatubaraiKbn pIkkatubaraiKbn) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.execFstPNyuukin( pRyosyuymd, pKyktuuka, pHrktuuka, pZenEigyoubiKsSyutokuYouhi, pHrkkaisuu,
            pSysKbn, pZennouMousideumu, pIkkatubaraiKbn);
    }


    @Override
    public BizNumber getKawaserate() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(0.0125);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1.308);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(2.0134);
            }
            else {
                return super.getKawaserate();
            }
        }

        return super.getKawaserate();
    }

    @Override
    public BizDate getKwsrateKjYmd() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizDate.valueOf("20160517");
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizDate.valueOf("20160418");
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizDate.valueOf("20160812");
            }
            else {
                return super.getKwsrateKjYmd();
            }
        }

        return super.getKwsrateKjYmd();
    }
}
