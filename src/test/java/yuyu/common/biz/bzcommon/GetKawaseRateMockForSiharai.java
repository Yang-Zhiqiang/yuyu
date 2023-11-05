package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
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
public class GetKawaseRateMockForSiharai extends GetKawaseRate {

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

    private String flag = "0";

    @Override
    public C_ErrorKbn exec(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn, C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn, C_KawasetsryKbn pKawasetsryKbn,
        C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {
        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKwsrateKjYmd, BizDate.valueOf("20180203")) == BizDateUtil.COMPARE_EQUAL) {
                    flag = "1";
                }
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                if (C_KawasetsryKbn.SYUKKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.OK;
                } else if (C_KawasetsryKbn.NYUKINRATE.eq(pKawasetsryKbn)) {
                    return C_ErrorKbn.ERROR;
                }
            }
        }

        return super.exec(pKwsrateKjYmd, pKawaserateSyuruiKbn, pMototuuka, pKanzantuuka, pKawaseteKiyoKbn,
            pKawasetsryKbn, pEigyoubiHoseiKbn, pZenEigyoubiKsSyutokuYouhi);
    }

    @Override
    public BizNumber getKawaserate() {
        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(101.12);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if ("0".equals(flag)) {
                    return BizNumber.valueOf(102.03);
                }
                if ("1".equals(flag)) {
                    return BizNumber.valueOf(120.03);
                }
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(102.04);
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizNumber.valueOf(102.06);
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.07);
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.08);
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.13);
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                return BizNumber.valueOf(120.15);
            }
        }

        return super.getKawaserate();
    }

    @Override
    public BizDate getKwsrateKjYmd() {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizDate.valueOf("20100112");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN3) {
            if ("0".equals(flag)) {
                return BizDate.valueOf("20100203");
            }
            if ("1".equals(flag)) {
                return BizDate.valueOf("20180202");
            }
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN4) {
            return BizDate.valueOf("20170206");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN5) {
            return BizDate.valueOf("20160208");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN6) {
            return BizDate.valueOf("20180207");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN7) {
            return BizDate.valueOf("20180208");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN8) {
            return BizDate.valueOf("20180213");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN9) {
            return BizDate.valueOf("20180215");
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN10) {
            return BizDate.valueOf("20181123");
        }

        return super.getKwsrateKjYmd();
    }
}
