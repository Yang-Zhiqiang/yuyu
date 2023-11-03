package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * {@link ChkSubSknnKaisiYmd}のモッククラスです。<br />
 */
public class ChkSubSknnKaisiYmdMock extends ChkSubSknnKaisiYmd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, BizDate pHkSknnKaisiYmd, JT_SiKykSyouhn pSiKykSyouhn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
        }
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pHkSknnKaisiYmd, pSiKykSyouhn, pChkKekkaBeanLst);
    }

}