package yuyu.common.biz.bzcommon;

import yuyu.common.hozen.khcommon.CheckKhMeigiAddrTest_exec;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;

/**
 * {@link BzChkAdrKetasuu}のモッククラスです。<br />
 */
public class BzChkAdrKetasuuMockForHozen extends BzChkAdrKetasuu {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public BzChkAdrKetasuuOutBean exec(String pJyuusyo1, String pJyuusyo2, String pJyuusyo3) {

        if (caller == CheckKhMeigiAddrTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzChkAdrKetasuuOutBean chkAdrKetasuuOutBean = new BzChkAdrKetasuuOutBean();

                chkAdrKetasuuOutBean.setJyougenKetasuuTyoukaKbn(C_JyougenketasuutyoukaKbn.CYOUKA);
                chkAdrKetasuuOutBean.setInKetasuu(1);
                chkAdrKetasuuOutBean.setInJyougenKetasuu(2);

                return chkAdrKetasuuOutBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                BzChkAdrKetasuuOutBean chkAdrKetasuuOutBean = new BzChkAdrKetasuuOutBean();

                chkAdrKetasuuOutBean.setJyougenKetasuuTyoukaKbn(C_JyougenketasuutyoukaKbn.JYOUGENNAI);
                chkAdrKetasuuOutBean.setInKetasuu(3);
                chkAdrKetasuuOutBean.setInJyougenKetasuu(4);

                return chkAdrKetasuuOutBean;
            }
        }

        return super.exec(pJyuusyo1, pJyuusyo2, pJyuusyo3);
    }
}
