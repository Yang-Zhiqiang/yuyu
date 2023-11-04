package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubMeigihenkou}のモッククラスです。<br />
 */
public class ChkSubMeigihenkouMockForSiharai extends ChkSubMeigihenkou {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, C_SeikyuuSyubetu pSeikyuuSyubetu, C_YouhiKbn pSateiKakMeigiHnkKbn,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pSeikyuuSyubetu, pSateiKakMeigiHnkKbn, pSiKykKihon, pChkKekkaBeanLst);
    }
}
