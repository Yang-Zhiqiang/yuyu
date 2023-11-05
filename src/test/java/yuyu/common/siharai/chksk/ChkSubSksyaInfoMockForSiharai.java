package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubSksyaInfo}のモッククラスです。<br />
 */
public class ChkSubSksyaInfoMockForSiharai extends ChkSubSksyaInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(C_SeikyuusyaKbn pSeikyuusyaKbn, String pSeikyuusyaNmkn, String pSeikyuusyaNmkj,
        BizDate pSeikyuusyaSeiYmd, C_Seibetu pSeikyuusyaSei, C_SeikyuuSyubetu pSeikyuuSyubetu,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return true;
            }
        }

        return super.exec(pSeikyuusyaKbn, pSeikyuusyaNmkn, pSeikyuusyaNmkj, pSeikyuusyaSeiYmd, pSeikyuusyaSei,
            pSeikyuuSyubetu, pSiKykKihon, pChkKekkaBeanLst);

    }

}
