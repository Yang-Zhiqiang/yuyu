package yuyu.common.biz.koutei;

import yuyu.common.biz.bzcommon.BzProcessUpdate;
import yuyu.common.biz.bzcommon.BzProcessUpdateInputBean;

/**
 * {@link BzProcessUpdate}のモッククラスです。<br />
 */
public class BzProcessUpdateMock extends BzProcessUpdate {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BzProcessUpdateInputBean pBzProcessUpdateInputBean) {

        super.exec(pBzProcessUpdateInputBean);
    }

}