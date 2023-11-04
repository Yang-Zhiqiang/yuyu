package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;

/**
 * {@link SetHurikaebi}のモッククラスです。<br />
 */
public class SetHurikaebiMockForSinkeiyaku extends SetHurikaebi {

    public static final String TESTPATTERN1= "1";

    public static final String TESTPATTERN2= "2";

    public static Class<?> caller = null;

    public int kaisu = 0;

    public static String SYORIPTN = null;

    @Override
    public BizDate getTyokuzenAnnaibi() {

        return super.getTyokuzenAnnaibi();
    }

    @Override
    public BizDate getTyokugoAnnaibi() {

        if (caller == CheckNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181121");
                }
                return BizDate.valueOf("20181122");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (kaisu == 0) {
                    kaisu++;
                    return BizDate.valueOf("20181021");
                }
                return BizDate.valueOf("20181122");
            }
        }

        return super.getTyokugoAnnaibi();
    }

    @Override
    public void exec(BizDate pJyutouYM) {

        if (caller == CheckNyuukinTest_exec.class) {
            return;
        }
        super.exec(pJyutouYM);
    }
}