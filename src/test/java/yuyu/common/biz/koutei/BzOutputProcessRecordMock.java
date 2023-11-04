package yuyu.common.biz.koutei;

import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.common.hozen.prereport.HozenPreReportOperateProcessTest_OperateProcess;
import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHenkinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiKaisyouTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninIraiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninKekkaTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiOnlineTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKyouseiHandTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExecTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenkenTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardNyuukinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardPaperlessMousikomiTest_kouteiSeni;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardSeirituHoryuuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokuninTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.prereport.SkPreReportOperateProcessTest_operateProcess;
import yuyu.common.sinkeiyaku.syoruitoutyaku.SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * {@link BzOutputProcessRecord}のモッククラスです。<br />
 */
public class BzOutputProcessRecordMock extends BzOutputProcessRecord {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pSyoriComment, String pTaskName,
        C_SyorikekkaKbn pSyorikekkaKbn) {

        if (caller == SkProcessForwardKankyouSateiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardImuSateiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardHenkinNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardMoschkExecTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkPreReportOperateProcessTest_operateProcess.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
        }
        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardKeiyakuKakuninIraiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardKeiyakuKakuninKekkaTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardTokuninTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardTeiseiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardHubiTourokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardSeirituHoryuuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardMousikomiTorikesiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardKyouseiHandTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardNyuukinNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardMousikomiTenkenTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessForwardHubiKaisyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class) {

        }
        else if (caller == SyoruitoutyakuOperateProcessTest_exec.class) {
            return;
        }
        else if (caller == SiharaiPreReportOperateProcessTest_operateProcess.class) {
            return;
        }
        else if (caller == HozenPreReportOperateProcessTest_OperateProcess.class) {
            return;
        }
        else if (caller == BzProcessForwardTest_exec.class) {
            return;
        }
        else if (caller == SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class && TESTPATTERN1.equals(SYORIPTN)) {

        }
        else if (caller == SkProcessCreateTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }
        else {
            super.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
        }
    }
}
