package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link KeisanKhGensen}のモッククラスです<br />
 */
public class KeisanKhGensenMock extends KeisanKhGensen {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static int flag = 0;

    @Override
    public C_ErrorKbn exec(
        String pSyono,
        C_Tuukasyu pTuukasyu,
        C_UmuKbn pYenshrtkUmu,
        BizCurrency pKaiyakuhr,
        BizCurrency pSonotashrkngkyen,
        BizDate pCalcKijyunYmd) {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (flag == 0) {
                    flag++;
                    return C_ErrorKbn.OK;
                }
                else if (flag == 1) {
                    flag++;
                    return C_ErrorKbn.ERROR;
                }
                else {
                    flag++;
                    return C_ErrorKbn.OK;
                }
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                flag++;
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pSyono, pTuukasyu, pYenshrtkUmu, pKaiyakuhr, pSonotashrkngkyen, pCalcKijyunYmd);

    }

    @Override
    public BizCurrency getYenGensen() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1002);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizCurrency.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizCurrency.valueOf(3101);
                }
                else {
                    return BizCurrency.valueOf(32001);
                }
            }
        }
        return super.getYenGensen();

    }

    @Override
    public C_RatesyutokukekkaKbn getRateSyutokuKekkaKbn() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_RatesyutokukekkaKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_RatesyutokukekkaKbn.SEIJYOU;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return C_RatesyutokukekkaKbn.SEIJYOU;
                }
                else if (flag == 2) {
                    return C_RatesyutokukekkaKbn.ERROR;
                }
                else {
                    return C_RatesyutokukekkaKbn.MINASHI;
                }
            }
        }

        return super.getRateSyutokuKekkaKbn();
    }

    @Override
    public BizDate getRatesyutokuYmd() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20181201");
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20181202");
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizDate.valueOf("20180601");
                }
                else if (flag == 2) {
                    return BizDate.valueOf("20180602");
                }
                else {
                    return BizDate.valueOf("20180603");
                }
            }
        }

        return super.getRatesyutokuYmd();
    }

    @Override
    public BizNumber getKawaseRate() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(1002);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizNumber.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizNumber.valueOf(3101);
                }
                else {
                    return BizNumber.valueOf(3201);
                }

            }
        }

        return super.getKawaseRate();
    }

    @Override
    public C_UmuKbn getGsBunriTaisyou() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                if (flag == 1) {
                    return C_UmuKbn.ARI;
                }
                else if (flag == 2){
                    return C_UmuKbn.NONE;
                }
                else {
                    return C_UmuKbn.NONE;
                }
            }
        }

        return super.getGsBunriTaisyou();
    }

    @Override
    public BizCurrency getYenHtyKeihi() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizCurrency.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizCurrency.valueOf(3101);
                }
                else {
                    return BizCurrency.valueOf(3201);
                }
            }
        }

        return super.getYenHtyKeihi();
    }

    @Override
    public BizCurrency getYenKztGk() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizCurrency.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizCurrency.valueOf(3101);
                }
                else {
                    return BizCurrency.valueOf(3201);
                }
            }
        }

        return super.getYenKztGk();
    }

    @Override
    public BizCurrency getGensen() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }

        return super.getGensen();
    }

    @Override
    public BizCurrency getYenGsTszeiGkKokuz() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizCurrency.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizCurrency.valueOf(3101);
                }
                else {
                    return BizCurrency.valueOf(3201);
                }
            }
        }

        return super.getYenGsTszeiGkKokuz();
    }

    @Override
    public BizCurrency getYenGsTszeiGkTihouz() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag == 1) {
                    return BizCurrency.valueOf(3001);
                }
                else if (flag == 2) {
                    return BizCurrency.valueOf(3101);
                }
                else {
                    return BizCurrency.valueOf(3201);
                }

            }
        }

        return super.getYenGsTszeiGkTihouz();
    }

    @Override
    public BizCurrency getYenW() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }

        return super.getYenW();
    }

}
