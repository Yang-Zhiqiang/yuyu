package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * {@link ChkSubJisatuMenseki}のモッククラスです。<br />
 */
public class ChkSubJisatuMensekiMockForSiharai extends ChkSubJisatuMenseki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, C_GeninKbn pGeninKbn, BizDate pHkSknnKaisiYmd,
        JT_SiKykSyouhn pSiKykSyouhn, JM_SiSyouhnZokusei pSiSyouhnZokusei,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
                pChkKekkaBeanLst.add(chkKekkaBean);
                ChkKekkaBean chkKekkaBean2 = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
                pChkKekkaBeanLst.add(chkKekkaBean2);
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pGeninKbn, pHkSknnKaisiYmd, pSiKykSyouhn, pSiSyouhnZokusei, pChkKekkaBeanLst);
    }
}
