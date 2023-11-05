package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;

/**
 * {@link BzGetImage}のモッククラスです。<br />
 */
public class BzGetImageMockForSinkeiyaku extends BzGetImage {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetImageOutputBean exec(String[] pImageId, String pUserId) {
        BzGetImageOutputBean outBean = SWAKInjector.getInstance(BzGetImageOutputBean.class);

        if (caller == SkProcessCreateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                outBean.setSyoriKekkaStatus(BzIwfUtilConstants.API_RESULTCD_OK);

                List<BzImageInfoBean> bzImageInfoBeanList = new ArrayList<>();
                BzImageInfoBean bzImageInfoBean = SWAKInjector.getInstance(BzImageInfoBean.class);
                bzImageInfoBean.setTorikomiSyoruiCd("BLNK");

                bzImageInfoBeanList.add(bzImageInfoBean);
                outBean.setBzImageInfoBeanList(bzImageInfoBeanList);

                return outBean;
            }
        }
        return super.exec(pImageId, pUserId);
    }
}
