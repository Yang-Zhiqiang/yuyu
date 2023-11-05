package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanKihrkP}のモッククラスです。<br />
 */
public class KeisanKihrkPMockForHozen extends KeisanKihrkP {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency getKihrkP() {

        if (caller == SetHaraikomiInfoTest_exec.class) {
            return BizCurrency.valueOf(4);
        }

        return super.getKihrkP();
    }

    @Override
    public BizCurrency getYenKihrkP() {

        if (caller == SetHaraikomiInfoTest_exec.class) {
            return BizCurrency.valueOf(4);
        }

        return super.getYenKihrkP();
    }

    @Override
    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {
        if (caller == SetHaraikomiInfoTest_exec.class) {
            return super.exec(pSyono, pKykTuukasyu);
        }

        return super.exec(pSyono, pKykTuukasyu);
    }
}
