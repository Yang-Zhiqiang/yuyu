package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * {@link SetYuuyokknmanryobi}のモッククラスです。<br />
 */
public class SetYuuyokknmanryobiMockForKhansyuu extends SetYuuyokknmanryobi {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public BizDate getYuuyokknMnrybi() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class)
            ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizDate.valueOf("20171231");
            }
        }

        if (caller == CheckYuuyokkngaiTest_exec.class) {

            return BizDate.valueOf("20140731");
        }
        return super.getYuuyokknMnrybi();
    }

    @Override
    public BizDate getTksnYuuyokknMnrybi() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizDate.valueOf("20171231");
            }
        }

        if (caller == CheckYuuyokkngaiTest_exec.class) {

            return BizDate.valueOf("20161010");
        }

        return super.getTksnYuuyokknMnrybi();
    }

    @Override
    public void exec(String pSyono, BizDateYM pJyutouYM) {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return;
            }

        }

        if (caller == CheckYuuyokkngaiTest_exec.class) {

            return ;
        }

        super.exec(pSyono, pJyutouYM);
    }
}