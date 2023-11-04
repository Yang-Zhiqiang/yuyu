package yuyu.common.biz.koutei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;

/**
 * {@link BzProcessCreate}のモッククラスです。<br />
 */
public class BzProcessCreateMockForSinkeiyaku extends BzProcessCreate {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzProcessCreateOutBean exec(BzProcessCreateInBean pBzProcessCreateInBean) {

        BzProcessCreateOutBean bzProcessCreateOutBean = SWAKInjector.getInstance(BzProcessCreateOutBean.class);

        if (caller == SkProcessCreateTest_exec.class) {
            if(SYORIPTN == TESTPATTERN1){
                super.exec(pBzProcessCreateInBean);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                bzProcessCreateOutBean.setKouteiKanriId("10010");
                return bzProcessCreateOutBean;
            }

            else if (SYORIPTN == TESTPATTERN2) {
                super.exec(pBzProcessCreateInBean);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
                bzProcessCreateOutBean.setKouteiKanriId("10010");
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN3) {
                super.exec(pBzProcessCreateInBean);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
                bzProcessCreateOutBean.setKouteiKanriId("10010");
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN4) {
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                bzProcessCreateOutBean.setKouteiKanriId(null);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN5) {
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                bzProcessCreateOutBean.setKouteiKanriId("TEST");
                return bzProcessCreateOutBean;
            }
        }
        return super.exec(pBzProcessCreateInBean);
    }
}