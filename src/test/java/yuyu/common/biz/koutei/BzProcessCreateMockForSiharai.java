package yuyu.common.biz.koutei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;

/**
 * {@link BzProcessCreate}のモッククラスです。<br />
 */
public class BzProcessCreateMockForSiharai extends BzProcessCreate {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzProcessCreateOutBean exec(BzProcessCreateInBean pBzProcessCreateInBean) {

        BzProcessCreateOutBean bzProcessCreateOutBean = SWAKInjector.getInstance(BzProcessCreateOutBean.class);

        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            if (SYORIPTN == TESTPATTERN1) {
                bzProcessCreateOutBean.setKouteiKanriId(null);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN2) {
                bzProcessCreateOutBean.setKouteiKanriId("slow1");
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN3) {
                bzProcessCreateOutBean.setKouteiKanriId(null);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN4) {
                bzProcessCreateOutBean = new BzProcessCreateOutBean();
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                bzProcessCreateOutBean.setKouteiKanriId("10010");
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN5) {
                bzProcessCreateOutBean.setKouteiKanriId(null);
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN6) {
                bzProcessCreateOutBean.setKouteiKanriId("slow1");
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
                return bzProcessCreateOutBean;
            }
            else if (SYORIPTN == TESTPATTERN7) {
                bzProcessCreateOutBean.setKouteiKanriId("slow2");
                bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
                return bzProcessCreateOutBean;
            }
        }
        return super.exec(pBzProcessCreateInBean);
    }
}