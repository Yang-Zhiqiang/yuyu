package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link KeisanKihrkP}のモッククラスです。<br />
 */
public class KeisanKihrkPMockForKhansyuu extends KeisanKihrkP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency kihrkP;

    private BizCurrency yenKihrkP;

    @Override
    public BizCurrency getKihrkP() {

        if (caller == SetHaraikomiInfoTest_exec.class) {
            return BizCurrency.valueOf(5);
        }

        return kihrkP;
    }

    public void setKihrkP(BizCurrency kihrkP) {
        this.kihrkP = kihrkP;
    }

    @Override
    public BizCurrency getYenKihrkP() {

        if (caller == SetHaraikomiInfoTest_exec.class) {
            return BizCurrency.valueOf(4);
        }

        return yenKihrkP;
    }

    public void setYenKihrkP(BizCurrency yenKihrkP) {
        this.yenKihrkP = yenKihrkP;
    }

    @Override
    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {
        if (caller == SetHaraikomiInfoTest_exec.class) {
            return super.exec(pSyono, pKykTuukasyu);
        }

        C_ErrorKbn errorKbn = super.exec(pSyono, pKykTuukasyu);

        this.yenKihrkP = super.getYenKihrkP();

        this.kihrkP = super.getKihrkP();

        return errorKbn;
    }
}
