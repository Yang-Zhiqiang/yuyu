package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.moschk.NayoseTest_exec;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;

/**
 * {@link DsNayose}のモッククラスです。<br />
 */
public class DsNayoseMock extends DsNayose{
    @Inject
    private static Logger logger;
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public DsNayoseBean exec(String pNmkn, String pNmkj, BizDate pSeiymd, String pPostalCd) {
        DsNayoseBean dsNayoseBean = SWAKInjector.getInstance(DsNayoseBean.class);
        if (caller == NayoseTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            dsNayoseBean.setKokno("");
            dsNayoseBean.setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn.DOUITUNONE);
            return dsNayoseBean;
        }
        else if (caller == NayoseTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            dsNayoseBean.setKokno("ds0001");
            dsNayoseBean.setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn.DOUITUARI);
            return dsNayoseBean;
        }
        else{
            return super.exec(pNmkn, pNmkj, pSeiymd, pPostalCd);
        }

    }

}
