package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.sicommon.SiSetUiBeanTest_setSateiSiharaiSatei;

/**
 * {@link BzGetSosikiData}のモッククラスです。<br />
 */
public class BzGetSosikiDataMock extends BzGetSosikiData {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public BzGetSosikiDataBean exec(String pSosikicd, BizDate pKijyunymd) {
        super.exec(pSosikicd, pKijyunymd);

        if (caller == SiSetUiBeanTest_setSateiSiharaiSatei.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetSosikiDataBean bzGetSosikiDataBean = SWAKInjector.getInstance(BzGetSosikiDataBean.class);
                bzGetSosikiDataBean.setKanjisosikinm20("DDD");
                return bzGetSosikiDataBean;
            }
        }

        return super.exec(pSosikicd, pKijyunymd);
    }
}
