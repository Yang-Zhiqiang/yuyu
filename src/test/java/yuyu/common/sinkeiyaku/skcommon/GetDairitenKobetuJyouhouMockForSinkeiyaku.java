package yuyu.common.sinkeiyaku.skcommon;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link GetDairitenKobetuJyouhou}のモッククラスです。<br />
 */
public class GetDairitenKobetuJyouhouMockForSinkeiyaku extends GetDairitenKobetuJyouhou {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetDairitenKobetuJyouhouBean exec(String pOyadrtenCd, C_MosUketukeKbn pMosUketukeKbn) {

        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = new GetDairitenKobetuJyouhouBean();
                getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.OK);
                getDairitenKobetuJyouhouBean.setCifCdCheckYouhi(C_YouhiKbn.YOU);
                getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(5);
                return getDairitenKobetuJyouhouBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = new GetDairitenKobetuJyouhouBean();
                getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.ERROR);
                getDairitenKobetuJyouhouBean.setCifCdCheckYouhi(C_YouhiKbn.YOU);
                getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(5);
                return getDairitenKobetuJyouhouBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = new GetDairitenKobetuJyouhouBean();
                getDairitenKobetuJyouhouBean.setErrorKbn(C_ErrorKbn.OK);
                getDairitenKobetuJyouhouBean.setCifCdCheckYouhi(C_YouhiKbn.HUYOU);
                getDairitenKobetuJyouhouBean.setCifCdSiteiKetasuu(5);
                return getDairitenKobetuJyouhouBean;
            }
        }
        return super.exec(pOyadrtenCd, pMosUketukeKbn);
    }
}