package yuyu.common.hozen.ascommon;

import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec4;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec5;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec7;
import jp.co.slcs.swak.date.BizDate;

/**
 * {@link SetMinusUriagebi}のモッククラスです。<br />
 */
public class SetMinusUriagebiMockForKhansyuu extends SetMinusUriagebi {

    private BizDate uriageSeikyuuYmd;
    private BizDate denpyouYmd;

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";
    @Override
    public void exec(BizDate pSyoriYmd){

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                uriageSeikyuuYmd = BizDate.valueOf(20151231);
                denpyouYmd = BizDate.valueOf(20151230);
            }
        }
        super.exec(pSyoriYmd);
    }

    @Override
    public BizDate getUriageSeikyuuYmd() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return uriageSeikyuuYmd;
            }
        }
        return super.getUriageSeikyuuYmd();
    }

    @Override
    public BizDate getDenpyouYmd() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec7.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return denpyouYmd;
            }
        }
        return super.getDenpyouYmd();
    }
}
