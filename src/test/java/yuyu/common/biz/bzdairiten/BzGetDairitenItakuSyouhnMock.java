package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;

/**
 * {@link BzGetDairitenItakuSyouhn}のモッククラスです。<br />
 */
public class BzGetDairitenItakuSyouhnMock extends BzGetDairitenItakuSyouhn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetDairitenItakuSyouhnBean exec(String pDrtenCd, C_DrtSyouhinSikibetuKbn pSyouhinSikibetuKbn,
        String pHrkhouhouKbn, String pPlannmKbn, BizDate pkijyunYmd) {

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhn =
                SWAKInjector.getInstance(BzGetDairitenItakuSyouhnBean.class);

            bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.HANBAITYUU);

            return bzGetDairitenItakuSyouhn;
        }

        if (caller == CheckTblMosDairitenTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            BzGetDairitenItakuSyouhnBean bzGetDairitenItakuSyouhn =
                SWAKInjector.getInstance(BzGetDairitenItakuSyouhnBean.class);

            bzGetDairitenItakuSyouhn.setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn.BLNK);

            return bzGetDairitenItakuSyouhn;
        }

        return super.exec(pDrtenCd, pSyouhinSikibetuKbn, pHrkhouhouKbn, pPlannmKbn, pkijyunYmd);
    }

}
