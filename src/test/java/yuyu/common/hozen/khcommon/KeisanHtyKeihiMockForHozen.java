package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 必要経費計算クラス{@link KeisanHtyKeihi}のモッククラスです。<br />
 */
public class KeisanHtyKeihiMockForHozen extends KeisanHtyKeihi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

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

        if (caller == KeisanCommonKaiyakuTest_keisanZeimuinfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == KeisanKhGensenTest_exec.class) {
            return C_ErrorKbn.OK;
        }
        return super.exec(pSyono, pKykTuukasyu);
    }

    @Override
    public BizCurrency getHtyKeihi() {

        if (caller == KeisanCommonKaiyakuTest_keisanZeimuinfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(1001);
                return htyKeihi;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(2001);
                return htyKeihi;
            }
        }
        else if (caller == KeisanKhGensenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                htyKeihi = BizCurrency.valueOf(2000.25);
                return htyKeihi;
            }
        }

        return super.getHtyKeihi();
    }

    @Override
    public BizCurrency getYenHtyKeihi() {

        if (caller == KeisanCommonKaiyakuTest_keisanZeimuinfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(1001);
                return yenHtyKeihi;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(2001);
                return yenHtyKeihi;
            }
        }
        else if (caller == KeisanKhGensenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenHtyKeihi = BizCurrency.valueOf(2000.65);
                return yenHtyKeihi;
            }
        }
        return super.getYenHtyKeihi();
    }
    @Override
    public BizCurrency getYenGenKykSyaHtyKeihi() {

        if (caller == KeisanCommonKaiyakuTest_keisanZeimuinfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(1001);
                return yenGenKykSyaHtyKeihi;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                yenGenKykSyaHtyKeihi = BizCurrency.valueOf(2001);
                return yenGenKykSyaHtyKeihi;
            }
        }

        return super.getYenGenKykSyaHtyKeihi();
    }

    @Override
    public int getKykSyaHenkouKaisuu() {

        if (caller == KeisanCommonKaiyakuTest_keisanZeimuinfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                kykSyaHenkouKaisuu = 0;
                return kykSyaHenkouKaisuu;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                kykSyaHenkouKaisuu = 1;
                return kykSyaHenkouKaisuu;
            }
        }
        return super.getKykSyaHenkouKaisuu();
    }
}
