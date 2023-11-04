package yuyu.common.siharai.koutei;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link SiHituyousyoruiHantei}のモッククラスです。<br />
 */
public class SiHituyousyoruiHanteiMock extends SiHituyousyoruiHantei {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<C_SyoruiCdKbn> exec(SiHituyousyoruiHanteiInBean pSiHituyousyoruiHanteiInBean) {

        List<C_SyoruiCdKbn> syoruiCdKbnLst = null;

        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN1) {
            syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();
            return syoruiCdKbnLst;
        }
        return super.exec(pSiHituyousyoruiHanteiInBean);
    }
}