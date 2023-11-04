package yuyu.common.biz.koutei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.hozen.prereport.HozenPreReportOperateProcessTest_OperateProcess;
import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.prereport.SkPreReportOperateProcessTest_operateProcess;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;

/**
 * {@link BzProcessCreate}のモッククラスです。<br />
 */
public class BzProcessCreateMock extends BzProcessCreate {

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

        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN1.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport");

            return bzProcessCreateOutBean;

        }

        else if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN2.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport");

            return bzProcessCreateOutBean;

        }

        else if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN3.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);

            return bzProcessCreateOutBean;

        }
        else if (caller == SkPreReportOperateProcessTest_operateProcess.class) {
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);

            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN1) {
            bzProcessCreateOutBean.setKouteiKanriId(null);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN2) {
            bzProcessCreateOutBean.setKouteiKanriId("slow1");
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN3) {
            bzProcessCreateOutBean.setKouteiKanriId(null);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN4) {
            bzProcessCreateOutBean = new BzProcessCreateOutBean();
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("10010");
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN5) {
            bzProcessCreateOutBean.setKouteiKanriId(null);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN6) {
            bzProcessCreateOutBean.setKouteiKanriId("slow1");
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            return bzProcessCreateOutBean;
        }
        else if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller && SYORIPTN == TESTPATTERN7) {
            bzProcessCreateOutBean.setKouteiKanriId("slow2");
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            return bzProcessCreateOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class && SYORIPTN == TESTPATTERN1) {
            super.exec(pBzProcessCreateInBean);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("10010");
            return bzProcessCreateOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class && SYORIPTN == TESTPATTERN2) {
            super.exec(pBzProcessCreateInBean);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            bzProcessCreateOutBean.setKouteiKanriId("10010");
            return bzProcessCreateOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class && SYORIPTN == TESTPATTERN3) {
            super.exec(pBzProcessCreateInBean);
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            bzProcessCreateOutBean.setKouteiKanriId("10010");
            return bzProcessCreateOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class && SYORIPTN == TESTPATTERN4) {
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId(null);
            return bzProcessCreateOutBean;
        }
        else if (caller == SkProcessCreateTest_exec.class && SYORIPTN == TESTPATTERN5) {
            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("TEST");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN8.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport1");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN9.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport2");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN10.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport3");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN11.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.SUCCESS);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport4");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN12.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport5");
            return bzProcessCreateOutBean;
        }
        if (caller == HozenPreReportOperateProcessTest_OperateProcess.class && TESTPATTERN13.equals(SYORIPTN)) {

            bzProcessCreateOutBean.setKouteiSakuseiKekkaKbn(C_KouteiSakuseiKekkaKbn.FAILURE);
            bzProcessCreateOutBean.setKouteiKanriId("NenkinPreReport6");
            return bzProcessCreateOutBean;
        }
        else {
            return super.exec(pBzProcessCreateInBean);
        }
    }
}