package yuyu.common.workflow.workflowutility;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;

/**
 * ワークフロー呼出ユーティリティクラスです。<br/>
 * YuyuWorkflowConfigを用いてデバッグモードの切り替えを行い呼出先の変更を行います。
 * デバッグモード：
 * true:WorkFlowUtilityTest.java 呼出 スタブ使用
 * false:WorkFlowUtilityExe.java 呼出 API使用
 */
public class WorkFlowUtility {

    static YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
    static boolean flg = config.isWorkflowStubMode();

    @Inject
    BizDomManager bizDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    static Logger logger = LoggerFactory.getLogger(WorkFlowUtility.class);

    public static GetLockedTaskListResultBean getLockedTasksInfoList(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pUserId,
        List<Map<String, String>> pAdditionalParam) {

        logger.debug("事務手続コード引数確認");
        for (String wk : pJimutetuzukiCd) {
            logger.debug("pJimutetuzukiCd : " + wk);
        }

        GetLockedTaskListResultBean resultBean = new GetLockedTaskListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getLockedTasksInfoListを呼び出します");
            resultBean = WorkFlowUtilityExe.getLockedTasksInfoList(
                pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pUserId, pAdditionalParam);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getLockedTasksInfoListを呼び出します");
            resultBean = WorkFlowUtilityTest.getLockedTasksInfoList(pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd,
                pUserId, pAdditionalParam);
        }
        return resultBean;
    }

    public static UnlockProcessForceResultBean unlockProcessForce(String pKouteiKnrId, String pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        UnlockProcessForceResultBean resultBean = new UnlockProcessForceResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.unlockProcessForceを呼び出します");
            resultBean = WorkFlowUtilityExe.unlockProcessForce(pKouteiKnrId, pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.unlockProcessForceを呼び出します");
            resultBean = WorkFlowUtilityTest.unlockProcessForce(pKouteiKnrId, pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetTaskTantoNmResultBean getTaskTantoNm(String[] pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        for (String wk : pJimutetuzukiCd) {
            logger.debug("pJimutetuzukiCd : " + wk);
        }

        GetTaskTantoNmResultBean resultBean = new GetTaskTantoNmResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTaskTantoNmを呼び出します");
            resultBean = WorkFlowUtilityExe.getTaskTantoNm(pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTaskTantoNmを呼び出します");
            resultBean = WorkFlowUtilityTest.getTaskTantoNm(pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetTaskTantoInfoListResultBean getTaskTantoInfoList(
        String pSubsystemId, String[] pJimutetuzukiCd, String pUserId, String pTaskNm) {

        logger.debug("事務手続コード引数確認");
        if (pJimutetuzukiCd != null) {
            for (String wk : pJimutetuzukiCd) {
                logger.debug("pJimutetuzukiCd : " + wk);
            }
        }

        GetTaskTantoInfoListResultBean resultBean = new GetTaskTantoInfoListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTaskTantoInfoListを呼び出します");
            resultBean = WorkFlowUtilityExe.getTaskTantoInfoList(pSubsystemId, pJimutetuzukiCd, pUserId, pTaskNm);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTaskTantoInfoListを呼び出します");
            resultBean = WorkFlowUtilityTest.getTaskTantoInfoList(pSubsystemId, pJimutetuzukiCd, pUserId, pTaskNm);
        }
        return resultBean;
    }

    public static WorkListUnassignTaskResultBean unassignTask(
        String pKouteiKnrId, String pJimutetuzukiCd, String pTaskNm, String pUserId,String pRirekiUserId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        WorkListUnassignTaskResultBean resultBean = new WorkListUnassignTaskResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.unassignTaskを呼び出します");
            resultBean = WorkFlowUtilityExe.unassignTask(pKouteiKnrId, pJimutetuzukiCd,pTaskNm, pUserId, pRirekiUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.unassignTaskを呼び出します");
            resultBean = WorkFlowUtilityTest.unassignTask(pKouteiKnrId, pJimutetuzukiCd,pTaskNm, pUserId, pRirekiUserId);
        }
        return resultBean;
    }

    public static GetTasksForCancelResultBean getTasksForCancel(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetTasksForCancelResultBean resultBean = new GetTasksForCancelResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForCancelを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForCancel(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForCancelを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForCancel(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetTasksForPutImageResultBean getTasksForPutImage(
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pSyoriStatus,
        String pJimuyouCd,
        String pWariateSousasyaId,
        String pIsWariate,
        String pSousasyaId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetTasksForPutImageResultBean resultBean = new GetTasksForPutImageResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForPutImageを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForPutImage(
                pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo, pJimuKaisiYmdFrom, pJimuKaisiYmdTo,
                pSyoriStatus, pJimuyouCd, pWariateSousasyaId, pIsWariate, pSousasyaId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForPutImageを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForPutImage(pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo,
                pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pSyoriStatus, pJimuyouCd, pWariateSousasyaId, pIsWariate,
                pSousasyaId);
        }
        return resultBean;
    }

    public static GetTasksForHyousiResultBean getTasksForHyousi(
        String pSubsystemId,
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pUserId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetTasksForHyousiResultBean resultBean = new GetTasksForHyousiResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForHyousiを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForHyousi(pSubsystemId, pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForHyousiを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForHyousi(pSubsystemId, pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo, pUserId);
        }
        return resultBean;
    }

    public static GetTasksForKouteiStatusResultBean getTasksForKouteiStatus(
        String pSubsystemId,
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pKouteiKanryouYmdFrom,
        String pKouteiKanryouYmdTo,
        String pLastUpdateYmdFrom,
        String pLastUpdateYmdTo,
        String[] pSyoriStatus,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pUserId,
        String pTaskNm,
        boolean pSubflowincludeCheckBox) {

        GetTasksForKouteiStatusResultBean resultBean = new GetTasksForKouteiStatusResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForKouteiStatusを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForKouteiStatus(pSubsystemId,
                pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo,
                pKouteiKanryouYmdFrom, pKouteiKanryouYmdTo, pLastUpdateYmdFrom, pLastUpdateYmdTo,
                pSyoriStatus, pJimuyouCd, pJimuyouCdUmu, pWariateUserId, pIsWariate, pUserId, pTaskNm, pSubflowincludeCheckBox);

        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForKouteiStatusを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForKouteiStatus(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo,
                pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pKouteiKanryouYmdFrom, pKouteiKanryouYmdTo,
                pLastUpdateYmdFrom, pLastUpdateYmdTo, pSyoriStatus, pJimuyouCd, pJimuyouCdUmu, pWariateUserId,
                pIsWariate, pUserId, pTaskNm, pSubflowincludeCheckBox);

        }
        return resultBean;
    }

    public static GetTasksForQrSealResultBean getTasksForQrSeal(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo) {

        GetTasksForQrSealResultBean resultBean = new GetTasksForQrSealResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForQrSealを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForQrSeal(pMosNo, pSyoNo, pNkSysyNo);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForQrSealを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForQrSeal(pMosNo, pSyoNo, pNkSysyNo);
        }
        return resultBean;
    }

    public static GetExecutableTasksForWorkListSkResultBean getExecutableTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pTaskNm,
        String[] pChannel,
        String[] pMousikomiHou,
        String[] pHknsyuruino,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetExecutableTasksForWorkListSkResultBean resultBean = new GetExecutableTasksForWorkListSkResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getExecutableTasksForWorkListSkを呼び出します");
            resultBean = WorkFlowUtilityExe.getExecutableTasksForWorkListSk(
                pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo,
                pMousikomiYmdFrom, pMousikomiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId, pTaskNm,
                pChannel, pMousikomiHou, pHknsyuruino, pDairiten, pChildDairitenUmu, pDoujiMousikomi);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getExecutableTasksForWorkListSkを呼び出します");
            resultBean = WorkFlowUtilityTest.getExecutableTasksForWorkListSk(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo,
                pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pMousikomiYmdFrom, pMousikomiYmdTo,
                pJimuyouCd, pJimuyouCdUmu, pWariateUserId, pTaskNm, pChannel, pMousikomiHou, pHknsyuruino,
                pDairiten, pChildDairitenUmu, pDoujiMousikomi);
        }
        return resultBean;
    }

    public static GetExecutableTasksForWorkListResultBean getExecutableTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetExecutableTasksForWorkListResultBean resultBean = new GetExecutableTasksForWorkListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getExecutableTasksForWorkListを呼び出します");
            resultBean = WorkFlowUtilityExe.getExecutableTasksForWorkList(
                pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getExecutableTasksForWorkListを呼び出します");
            resultBean = WorkFlowUtilityTest.getExecutableTasksForWorkList(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo,
                pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId);
        }
        return resultBean;
    }

    public static GetTasksForWorkListSkResultBean getTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm,
        String[] pChannel,
        String[] pMousikomiHou,
        String[] pHknsyuruino,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetTasksForWorkListSkResultBean resultBean = new GetTasksForWorkListSkResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForWorkListSkを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForWorkListSk(
                pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo,
                pMousikomiYmdFrom, pMousikomiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId,
                pIsWariate, pTaskNm, pChannel, pMousikomiHou, pHknsyuruino, pDairiten,
                pChildDairitenUmu, pDoujiMousikomi);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForWorkListSkを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForWorkListSk(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo,
                pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pMousikomiYmdFrom, pMousikomiYmdTo,
                pJimuyouCd, pJimuyouCdUmu, pWariateUserId, pIsWariate, pTaskNm, pChannel, pMousikomiHou,
                pHknsyuruino, pDairiten, pChildDairitenUmu, pDoujiMousikomi);
        }
        return resultBean;
    }

    public static GetTasksForWorkListResultBean getTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetTasksForWorkListResultBean resultBean = new GetTasksForWorkListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForWorkListを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForWorkList(
                pSubsystemId, pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd, pJimuKaisiYmdFrom,
                pJimuKaisiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId, pIsWariate, pTaskNm);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForWorkListを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForWorkList(pSubsystemId, pMosNo, pSyoNo, pNkSysyNo,
                pJimutetuzukiCd, pJimuKaisiYmdFrom, pJimuKaisiYmdTo, pJimuyouCd, pJimuyouCdUmu, pWariateUserId,
                pIsWariate, pTaskNm);
        }
        return resultBean;
    }

    public static GetTasksForJimuyouCdResultBean getTasksForJimuyouCd(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        for (String wk : pJimutetuzukiCd) {
            logger.debug("pJimutetuzukiCd : " + wk);
        }

        GetTasksForJimuyouCdResultBean resultBean = new GetTasksForJimuyouCdResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTasksForJimuyouCdを呼び出します");
            resultBean = WorkFlowUtilityExe.getTasksForJimuyouCd(pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTasksForJimuyouCdを呼び出します");
            resultBean = WorkFlowUtilityTest.getTasksForJimuyouCd(pMosNo, pSyoNo, pNkSysyNo, pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static CancelProcessResultBean cancelProcess(
        String pKouteiKnrId, String pJimutetuzukiCd, String pUserId, String pComment) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        CancelProcessResultBean resultBean = new CancelProcessResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.cancelProcessを呼び出します");
            resultBean = WorkFlowUtilityExe.cancelProcess(pKouteiKnrId, pJimutetuzukiCd, pUserId, pComment);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.cancelProcessを呼び出します");
            resultBean = WorkFlowUtilityTest.cancelProcess(pKouteiKnrId, pJimutetuzukiCd, pUserId, pComment);
        }
        return resultBean;
    }

    public static GetProcessHistoryResultBean getProcessHistory(String pKouteiKnrId, String pJimutetuzukiCd) {

        GetProcessHistoryResultBean resultBean = new GetProcessHistoryResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getProcessHistoryを呼び出します");
            resultBean = WorkFlowUtilityExe.getProcessHistory(pKouteiKnrId, pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getProcessHistoryを呼び出します");
            resultBean = WorkFlowUtilityTest.getProcessHistory(pKouteiKnrId, pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetTorikomiSyoruiMstResultBean getTorikomiSyoruiMst(String[] pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        if (pJimutetuzukiCd != null) {
            for (String wk : pJimutetuzukiCd) {
                logger.debug("pJimutetuzukiCd : " + wk);
            }
        }

        GetTorikomiSyoruiMstResultBean resultBean = new GetTorikomiSyoruiMstResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTorikomiSyoruiMstを呼び出します");
            resultBean = WorkFlowUtilityExe.getTorikomiSyoruiMst(pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityTest.getTorikomiSyoruiMstを呼び出します");
            resultBean = WorkFlowUtilityTest.getTorikomiSyoruiMst(pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetImagePropsListResultBean getImagePropsList(
        String pSubsystemId,
        String pUserId,
        String[] pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pSyoruiCd,
        String pToutyakuYmdTimeFrom,
        String pToutyakuYmdTimeTo,
        String pKouteiStatus) {

        logger.debug("事務手続コード引数確認");
        if (pJimutetuzukiCd != null) {
            for (String wk : pJimutetuzukiCd) {
                logger.debug("pJimutetuzukiCd : " + wk);
            }
        }

        GetImagePropsListResultBean resultBean = new GetImagePropsListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getImagePropsListを呼び出します");
            resultBean = WorkFlowUtilityExe.getImagePropsList(
                pSubsystemId, pUserId, pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo, pSyoruiCd,
                pToutyakuYmdTimeFrom, pToutyakuYmdTimeTo, pKouteiStatus);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getImagePropsListを呼び出します");
            resultBean = WorkFlowUtilityTest.getImagePropsList(
                pSubsystemId, pUserId, pJimutetuzukiCd, pMosNo, pSyoNo, pNkSysyNo, pSyoruiCd,
                pToutyakuYmdTimeFrom, pToutyakuYmdTimeTo, pKouteiStatus);
        }
        return resultBean;
    }

    public static GetImageInfoListResultBean getImage(String pImageId, String pUserId) {

        GetImageInfoListResultBean resultBean = new GetImageInfoListResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getImageを呼び出します");
            resultBean = WorkFlowUtilityExe.getImage(pImageId, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getImageを呼び出します");
            resultBean = WorkFlowUtilityTest.getImage(pImageId, pUserId);
        }
        return resultBean;
    }

    public static PutImageResultBean putImage(
        String pTorikomiSyoruiCd,
        String pUserId,
        String pJimutetuzukiCd,
        byte[] pImage,
        String pKouteiKnrId,
        String pToutyakuYmdTime,
        String pTourokuYmdTime,
        String pRyouikiSakuseiUmu) {

        PutImageResultBean resultBean = new PutImageResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.putImageを呼び出します");
            resultBean = WorkFlowUtilityExe.putImage(
                pTorikomiSyoruiCd, pUserId, pJimutetuzukiCd, pImage, pKouteiKnrId,
                pToutyakuYmdTime, pTourokuYmdTime, pRyouikiSakuseiUmu);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.putImageを呼び出します");
            resultBean = WorkFlowUtilityTest.putImage(
                pTorikomiSyoruiCd, pUserId, pJimutetuzukiCd, pImage, pKouteiKnrId,
                pToutyakuYmdTime, pTourokuYmdTime, pRyouikiSakuseiUmu);
        }
        return resultBean;
    }

    public static DropImageResultBean dropImage(String pImageId, String pUserId) {

        DropImageResultBean resultBean = new DropImageResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.dropImageを呼び出します");
            resultBean = WorkFlowUtilityExe.dropImage(pImageId, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.dropImageを呼び出します");
            resultBean = WorkFlowUtilityTest.dropImage(pImageId, pUserId);
        }
        return resultBean;
    }

    public static CreateProcessIkkatuResultBean createProcessIkkatu(List<CreateProcessIkkatuInBean> pInBeanList) {

        CreateProcessIkkatuResultBean resultBean = new CreateProcessIkkatuResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.createProcessIkkatuを呼び出します");
            resultBean = WorkFlowUtilityExe.createProcessIkkatu(pInBeanList);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.createProcessIkkatuを呼び出します");
            resultBean = WorkFlowUtilityTest.createProcessIkkatu(pInBeanList);
        }
        return resultBean;
    }

    public static GetSyoruiKengenResultBean getSyoruiKengen(
        String pRollCd, String[] pJimutetuzukiCd, String pUserId) {

        logger.debug("事務手続コード引数確認");
        for (String wk : pJimutetuzukiCd) {
            logger.debug("pJimutetuzukiCd : " + wk);
        }

        GetSyoruiKengenResultBean resultBean = new GetSyoruiKengenResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityExe.getSyoruiKengen(pRollCd, pJimutetuzukiCd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE");
            logger.debug("WorkFlowUtilityTest.getSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityTest.getSyoruiKengen(pRollCd, pJimutetuzukiCd, pUserId);
        }
        return resultBean;
    }

    public static PutSyoruiKengenResultBean putSyoruiKengen(String pRollCd, String[] pSyoruiCd) {

        PutSyoruiKengenResultBean resultBean = new PutSyoruiKengenResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.putSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityExe.putSyoruiKengen(pRollCd, pSyoruiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.putSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityTest.putSyoruiKengen(pRollCd, pSyoruiCd);
        }
        return resultBean;
    }

    public static DropSyoruiKengenResultBean dropSyoruiKengen(String pRollCd) {

        DropSyoruiKengenResultBean resultBean = new DropSyoruiKengenResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.dropSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityExe.dropSyoruiKengen(pRollCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.dropSyoruiKengenを呼び出します");
            resultBean = WorkFlowUtilityTest.dropSyoruiKengen(pRollCd);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfTaskSummaryBySubsystem(
        String[] pSubsystemId, String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfTaskSummaryBySubsystem(pSubsystemId, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfTaskSummaryBySubsystem(pSubsystemId, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(
        String pSubsystemId, String pJimutetuzukiCd, String pUserId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfTaskSummaryByJimutetuzuki(pSubsystemId, pJimutetuzukiCd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfTaskSummaryByJimutetuzuki(pSubsystemId, pJimutetuzukiCd, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfTaskSummaryByTask(
        String pJimutetuzukiCd, String pTaskNm, String pUserId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfTaskSummaryByTask(pJimutetuzukiCd, pTaskNm, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfTaskSummaryByTask(pJimutetuzukiCd, pTaskNm, pUserId);
        }
        return resultBean;
    }

    public static MakeCountOfTaskSummaryResultBean makeCountOfTaskSummary() {

        MakeCountOfTaskSummaryResultBean resultBean = new MakeCountOfTaskSummaryResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.makeCountOfTaskSummaryを呼び出します");
            resultBean = WorkFlowUtilityExe.makeCountOfTaskSummary();
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.makeCountOfTaskSummaryを呼び出します");
            resultBean = WorkFlowUtilityTest.makeCountOfTaskSummary();
        }
        return resultBean;
    }

    public static PutJimuyouCdResultBean putJimuyouCd(String pJimutetuzukiCd, String pUserId,
        List<PutJimuyouCdBean> pPutJimuyouCdBeanLst) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        PutJimuyouCdResultBean resultBean = new PutJimuyouCdResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.putJimuyouCdを呼び出します");
            resultBean = WorkFlowUtilityExe.putJimuyouCd(pJimutetuzukiCd, pUserId, pPutJimuyouCdBeanLst);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.putJimuyouCdを呼び出します");
            resultBean = WorkFlowUtilityTest.putJimuyouCd(pJimutetuzukiCd, pUserId, pPutJimuyouCdBeanLst);
        }
        return resultBean;
    }

    public static GetTorikomiSyoruiMstAndKengenResultBean getTorikomiSyoruiMstAndKengen(
        String[] pJimutetuzukiCd, String pUserId) {

        logger.debug("事務手続コード引数確認");

        if (pJimutetuzukiCd != null) {
            logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);
        }

        GetTorikomiSyoruiMstAndKengenResultBean resultBean = new GetTorikomiSyoruiMstAndKengenResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTorikomiSyoruiMstAndKengenを呼び出します");
            resultBean = WorkFlowUtilityExe.getTorikomiSyoruiMstAndKengen(pJimutetuzukiCd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTorikomiSyoruiMstAndKengenを呼び出します");
            resultBean = WorkFlowUtilityTest.getTorikomiSyoruiMstAndKengen(pJimutetuzukiCd, pUserId);
        }
        return resultBean;
    }

    public static PutExpectedArrivalNoticeResultBean putExpectedArrivalNotice(
        String pKouteiKnrId, String pQrCd, String pSyoruiCd, String pJimutetuzukiCd, String pSubSystemId) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        PutExpectedArrivalNoticeResultBean resultBean = new PutExpectedArrivalNoticeResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.putExpectedArrivalNoticeを呼び出します");
            resultBean = WorkFlowUtilityExe.putExpectedArrivalNotice(
                pKouteiKnrId, pQrCd, pSyoruiCd, pJimutetuzukiCd, pSubSystemId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.putExpectedArrivalNoticeを呼び出します");
            resultBean = WorkFlowUtilityTest.putExpectedArrivalNotice(
                pKouteiKnrId, pQrCd, pSyoruiCd, pJimutetuzukiCd, pSubSystemId);
        }
        return resultBean;
    }

    public static GetExpectedArrivalNoticeResultBean getExpectedArrivalNotice(String[] pQrCds) {

        GetExpectedArrivalNoticeResultBean resultBean = new GetExpectedArrivalNoticeResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getExpectedArrivalNoticeを呼び出します");
            resultBean = WorkFlowUtilityExe.getExpectedArrivalNotice(pQrCds);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getExpectedArrivalNoticeを呼び出します");
            resultBean = WorkFlowUtilityTest.getExpectedArrivalNotice(pQrCds);
        }
        return resultBean;

    }

    public static PutArrivalImageResultBean putArrivalImage(String pQrCd, byte[] pImage, String pKouteikanriId) {

        PutArrivalImageResultBean resultBean = new PutArrivalImageResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.putArrivalImageを呼び出します");
            resultBean = WorkFlowUtilityExe.putArrivalImage(pQrCd, pImage, pKouteikanriId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.putArrivalImageを呼び出します");
            resultBean = WorkFlowUtilityTest.putArrivalImage(pQrCd, pImage, pKouteikanriId);
        }
        return resultBean;
    }

    public static GetTorikomiSyoruiMstBySyoruiCdResultBean getTorikomiSyoruiMstBySyoruiCd(String pSyoruiCd) {
        GetTorikomiSyoruiMstBySyoruiCdResultBean resultBean = new GetTorikomiSyoruiMstBySyoruiCdResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getTorikomiSyoruiMstBySyoruiCdを呼び出します");
            resultBean = WorkFlowUtilityExe.getTorikomiSyoruiMstBySyoruiCd(pSyoruiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getTorikomiSyoruiMstBySyoruiCdを呼び出します");
            resultBean = WorkFlowUtilityTest.getTorikomiSyoruiMstBySyoruiCd(pSyoruiCd);
        }
        return resultBean;
    }

    public static GetScanTorikomiSyoruiMstResultBean getScanTorikomiSyoruiMst(String pJimutetuzukiCd) {

        logger.debug("事務手続コード引数確認");
        logger.debug("pJimutetuzukiCd : " + pJimutetuzukiCd);

        GetScanTorikomiSyoruiMstResultBean resultBean = new GetScanTorikomiSyoruiMstResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getScanTorikomiSyoruiMstを呼び出します");
            resultBean = WorkFlowUtilityExe.getScanTorikomiSyoruiMst(pJimutetuzukiCd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getScanTorikomiSyoruiMstを呼び出します");
            resultBean = WorkFlowUtilityTest.getScanTorikomiSyoruiMst(pJimutetuzukiCd);
        }
        return resultBean;
    }

    public static GetLockInfoResultBean getLockInfo(String pKouteiKnrId) {

        logger.debug("工程管理ID引数確認");
        logger.debug("pKouteiKnrId : " + pKouteiKnrId);

        GetLockInfoResultBean resultBean = SWAKInjector.getInstance(GetLockInfoResultBean.class);

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getLockInfoを呼び出します");
            resultBean = WorkFlowUtilityExe.getLockInfo(pKouteiKnrId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getLockInfoを呼び出します");
            resultBean = WorkFlowUtilityTest.getLockInfo(pKouteiKnrId);
        }
        return resultBean;
    }


    public static MakeCountOfKakoJissekiTaskSummaryResultBean makeCountOfKakoJissekiTaskSummary(
        BizDate pSyoriYmd) {

        MakeCountOfKakoJissekiTaskSummaryResultBean resultBean =
            SWAKInjector.getInstance(MakeCountOfKakoJissekiTaskSummaryResultBean.class);

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.makeCountOfKakoJissekiTaskSummaryを呼び出します");
            resultBean = WorkFlowUtilityExe.makeCountOfKakoJissekiTaskSummary(pSyoriYmd);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.makeCountOfKakoJissekiTaskSummaryを呼び出します");
            resultBean = WorkFlowUtilityTest.makeCountOfKakoJissekiTaskSummary(pSyoriYmd);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmd, String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean =
            new GetCountOfTaskSummaryBySubsystemResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryBySubsystem(
                pSubsystemId, pSyoriYmd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryBySubsystem(
                pSubsystemId, pSyoriYmd, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmd, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean =
            new GetCountOfTaskSummaryByJimutetuzukiResultBean();

        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(pSubsystemId, pSyoriYmd,
                pJimutetuzukiCd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByJimutetuzuki(pSubsystemId, pSyoriYmd,
                pJimutetuzukiCd, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(
        BizDate pSyoriYmd, String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByTask(pSyoriYmd, pJimutetuzukiCd,
                pTaskId, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByTask(pSyoriYmd, pJimutetuzukiCd,
                pTaskId, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryBySubsystem(pSubsystemId, pSyoriYmdFrom,
                pSyoriYmdTo, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryBySubsystemを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryBySubsystem(pSubsystemId, pSyoriYmdFrom,
                pSyoriYmdTo, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfTaskSummaryByJimutetuzuki(pSubsystemId, pSyoriYmdFrom,
                pSyoriYmdTo, pJimutetuzukiCd, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfTaskSummaryByJimutetuzukiを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfTaskSummaryByJimutetuzuki(pSubsystemId, pSyoriYmdFrom,
                pSyoriYmdTo, pJimutetuzukiCd, pUserId);
        }
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByTask(pSyoriYmdFrom, pSyoriYmdTo,
                pJimutetuzukiCd, pTaskId, pUserId);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByTask(pSyoriYmdFrom, pSyoriYmdTo,
                pJimutetuzukiCd, pTaskId, pUserId);
        }
        return resultBean;
    }

    public static GetSumiTaskByUserResultBean getSumiTaskByUser(String pSubSystemId, String pUserId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        GetSumiTaskByUserResultBean resultBean = new GetSumiTaskByUserResultBean();
        if (!flg) {
            logger.debug("デバッグモード FALSE\n");
            logger.debug("WorkFlowUtilityExe.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityExe.getSumiTask(pSubSystemId, pUserId,
                pSyoriYmdFrom, pSyoriYmdTo);
        } else {
            logger.debug("デバッグモード TRUE\n");
            logger.debug("WorkFlowUtilityTest.getCountOfKakoJissekiTaskSummaryByTaskを呼び出します");
            resultBean = WorkFlowUtilityTest.getSumiTask(pSubSystemId, pUserId,
                pSyoriYmdFrom, pSyoriYmdTo);
        }
        return resultBean;
    }
}