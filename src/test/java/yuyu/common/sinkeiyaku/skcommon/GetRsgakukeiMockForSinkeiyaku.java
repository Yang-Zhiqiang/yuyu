package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * {@link GetRsgakukei}のモッククラスです。<br />
 */
public class GetRsgakukeiMockForSinkeiyaku extends GetRsgakukei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void getHenkinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu) {
        super.getHenkinsumiRsgaku(pSyoriCTL, pTuukasyu);
    }

    @Override
    public BizCurrency getRsgakukei() {

        if (caller == SetKisoKoumokuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(300);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(200);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
            else {
                return super.getRsgakukei();
            }
        }

        return super.getRsgakukei();
    }

    @Override
    public C_Tuukasyu getTuukasyu() {
        return super.getTuukasyu();
    }

}