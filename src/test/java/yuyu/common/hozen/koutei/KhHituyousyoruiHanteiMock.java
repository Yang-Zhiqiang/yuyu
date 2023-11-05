package yuyu.common.hozen.koutei;

import java.util.List;

import yuyu.common.hozen.prereport.HozenPreReportOperateProcessTest_OperateProcess;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link KhHituyousyoruiHantei}のモッククラスです。<br />
 */
public class KhHituyousyoruiHanteiMock extends KhHituyousyoruiHantei{


    public static Class<?> caller = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN2 = "2";

    public static String SYORIPTN = null;
    @Override
    public List<C_SyoruiCdKbn> exec(KhHituyousyoruiHanteiInBean pKhHituyousyoruiHanteiInBean) {
        if (HozenPreReportOperateProcessTest_OperateProcess.class == caller&& SYORIPTN == TESTPATTERN1) {
            return null;
        }
        if (HozenPreReportOperateProcessTest_OperateProcess.class == caller&& SYORIPTN == TESTPATTERN2) {
            return null;
        }
        return super.exec(pKhHituyousyoruiHanteiInBean);
    }
}

