package yuyu.common.biz.koutei;

import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * {@link BzOutputProcessRecord}のモッククラスです。<br />
 */
public class BzOutputProcessRecordMockForSiharai extends BzOutputProcessRecord {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pSyoriComment, String pTaskName,
        C_SyorikekkaKbn pSyorikekkaKbn) {

        if (caller == SiharaiPreReportOperateProcessTest_operateProcess.class) {
            return;
        }

        super.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
    }
}
