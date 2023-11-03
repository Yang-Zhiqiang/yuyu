package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * {@link ChkSubSkSyorui}のモッククラスです。<br />
 */
public class ChkSubSkSyoruiMock extends ChkSubSkSyorui {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                pChkKekkaBeanLst.add(chkKekkaBean);
                return;
            }
        }

        super.exec(pSkKihon, pChkKekkaBeanLst);

    }

}
