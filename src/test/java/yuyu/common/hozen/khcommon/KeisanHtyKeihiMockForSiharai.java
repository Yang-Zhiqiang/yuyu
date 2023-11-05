package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutokuTest_getInfos;
import yuyu.common.siharai.sicommon.CalcHkHtykeihiTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanHtyKeihi}のモッククラスです。<br />
 */
public class KeisanHtyKeihiMockForSiharai extends KeisanHtyKeihi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public String flagKaisuu = "0";

    public String flagYen = "0";


    private BizCurrency htyKeihi;

    private BizCurrency yenHtyKeihi;


    private BizCurrency yenGenKykSyaHtyKeihi;

    private Integer kykSyaHenkouKaisuu;

    @Override
    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {
        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN)
                && ("11810111129".equals(pSyono) || "11810111141".equals(pSyono) || "11810111163".equals(pSyono))) {
                flagKaisuu = "1";
            } else if (TESTPATTERN1.equals(SYORIPTN) && "11810111174".equals(pSyono)) {
                flagKaisuu = "1";
                flagYen = "1";
            }
            return C_ErrorKbn.OK;
        }
        if (caller == CalcHkHtykeihiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pSyono, pKykTuukasyu);
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)
                && ("11810111129".equals(pSyono) || "11810111141".equals(pSyono) || "11810111163".equals(pSyono))) {
                flagKaisuu = "1";
            } else if (TESTPATTERN1.equals(SYORIPTN) && "11810111174".equals(pSyono)) {
                flagKaisuu = "1";
                flagYen = "1";
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                flagKaisuu = "2";
            }
            return C_ErrorKbn.OK;
        }


        return super.exec(pSyono, pKykTuukasyu);
    }

    @Override
    public BizCurrency getHtyKeihi() {
        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(11111);
                return htyKeihi;
            }
        }
        if (caller == CalcHkHtykeihiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                return htyKeihi;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(12000, BizCurrencyTypes.YEN);
                return htyKeihi;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(12000, BizCurrencyTypes.DOLLAR);
                return htyKeihi;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(32000, BizCurrencyTypes.EURO);
                return htyKeihi;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
                return htyKeihi;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                return htyKeihi;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(32000, BizCurrencyTypes.DOLLAR);
                return htyKeihi;
            }
        }
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(11111);
                return htyKeihi;
            }
        }

        return super.getHtyKeihi();
    }

    @Override
    public BizCurrency getYenHtyKeihi() {
        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(22222);
                return yenHtyKeihi;
            }
        }
        if (caller == CalcHkHtykeihiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(22000, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(22000, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(42000, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(42000, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                return yenHtyKeihi;
            }
        }
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(22222);
                return yenHtyKeihi;
            }
        }

        return super.getYenHtyKeihi();
    }

    @Override
    public BizCurrency getYenGenKykSyaHtyKeihi() {
        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN) && "0".equals(flagYen)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(0);
                return yenGenKykSyaHtyKeihi;
            } else if (TESTPATTERN1.equals(SYORIPTN) && "1".equals(flagYen)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(12345678900.00);
                return yenGenKykSyaHtyKeihi;
            }
        }
        if (caller == CalcHkHtykeihiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(11000, BizCurrencyTypes.YEN);
                return yenGenKykSyaHtyKeihi;
            }
        }
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) && "0".equals(flagYen)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(0);
                return yenGenKykSyaHtyKeihi;
            } else if (TESTPATTERN1.equals(SYORIPTN) && "1".equals(flagYen)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(12345678900.00);
                return yenGenKykSyaHtyKeihi;
            }
        }

        return super.getYenGenKykSyaHtyKeihi();
    }

    @Override
    public int getKykSyaHenkouKaisuu() {
        if (caller == KeiyakuInfoSyutokuTest_getInfos.class) {
            if (TESTPATTERN1.equals(SYORIPTN) && "0".equals(flagKaisuu)) {
                kykSyaHenkouKaisuu = 0;
                return kykSyaHenkouKaisuu;
            } else if (TESTPATTERN1.equals(SYORIPTN) && "1".equals(flagKaisuu)) {
                kykSyaHenkouKaisuu = 1;
                return kykSyaHenkouKaisuu;
            }
        }
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN) && "0".equals(flagKaisuu)) {
                kykSyaHenkouKaisuu = 0;
                return kykSyaHenkouKaisuu;
            } else if (TESTPATTERN1.equals(SYORIPTN) && "1".equals(flagKaisuu)) {
                kykSyaHenkouKaisuu = 1;
                return kykSyaHenkouKaisuu;
            } else if (TESTPATTERN2.equals(SYORIPTN) && "2".equals(flagKaisuu)) {
                kykSyaHenkouKaisuu = 2;
                return kykSyaHenkouKaisuu;
            }
        }
        return super.getKykSyaHenkouKaisuu();
    }

}
