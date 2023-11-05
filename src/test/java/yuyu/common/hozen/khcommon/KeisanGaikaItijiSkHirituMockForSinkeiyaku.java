package yuyu.common.hozen.khcommon;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import jp.co.slcs.swak.number.BizNumber;

/**
 * {@link KeisanGaikaItijiSkHiritu}のモッククラスです。<br />
 */
public class KeisanGaikaItijiSkHirituMockForSinkeiyaku extends KeisanGaikaItijiSkHiritu {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public BizNumber exec(BizNumber pYoteiRiritu, int pHhknNen) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            pYoteiRiritu = null;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return BizNumber.ZERO;
        }

        return super.exec(pYoteiRiritu, pHhknNen);
    }

}
