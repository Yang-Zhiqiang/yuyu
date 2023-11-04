package yuyu.common.hozen.khcommon;

import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;
import jp.co.slcs.swak.date.BizDate;

/**
 * {@link SetHurikaebi}のモッククラスです。<br />
 */
public class SetHurikaebiMock extends SetHurikaebi {

    public static final String TESTPATTERN1= "1";

    public static final String TESTPATTERN2= "2";

    public static Class<?> caller = null;

    public int kaisu = 0;

    public static String SYORIPTN = null;

    @Override
    public BizDate getTyokuzenAnnaibi() {

        if (caller == SetAnnaibiTest_exec.class) {
            return BizDate.valueOf("20180927");
        }
        return super.getTyokuzenAnnaibi();
    }

    @Override
    public BizDate getTyokugoAnnaibi() {

        if (caller == SetAnnaibiTest_exec.class) {
            return BizDate.valueOf("20181027");
        }
        if (caller == CheckNyuukinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            if (kaisu == 0) {
                kaisu++;
                return BizDate.valueOf("20181121");
            }
            return BizDate.valueOf("20181122");
        }
        if (caller == CheckNyuukinTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if (kaisu == 0) {
                kaisu++;
                return BizDate.valueOf("20181021");
            }
            return BizDate.valueOf("20181122");
        }
        return super.getTyokugoAnnaibi();
    }

    @Override
    public void exec(BizDate pJyutouYM) {

        if (caller == SetAnnaibiTest_exec.class) {
            return;
        }
        if (caller == CheckNyuukinTest_exec.class) {
            return;
        }
        super.exec(pJyutouYM);
    }
}