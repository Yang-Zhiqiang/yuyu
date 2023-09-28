package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskOutBean;
import yuyu.def.MessageId;

/**
 * 業務共通 工程 業務共通強制タスク開始
 */
public class BzForceTaskStart {

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzForceProcessForward bzForceProcessForward;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzForceTaskStart() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pTaskId, String pKouteiLockKey) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        String wariateTantId = "";
        String kekkaStatus = "";
        String syousaiMsgCd = "";

        if (bzGetProcessSummaryOutBean.getNowNodoId().equals(pTaskId)) {
            wariateTantId = bzGetProcessSummaryOutBean.getNowTantId();
        }
        else {
            bzForceProcessForward.exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey);
        }

        if (BizUtil.isBlank(wariateTantId)) {
        }
        else if (wariateTantId.equals(baseUserInfo.getUserId())) {
            return;
        }
        else {
            UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();

            unassignTaskInBean.setGyoumukey(pKouteiKanriId);
            unassignTaskInBean.setFlowid(pJimuTetuzukiCd);
            unassignTaskInBean.setAccountid(wariateTantId);
            unassignTaskInBean.setRirekiaccountid(baseUserInfo.getUserId());
            unassignTaskInBean.setLockkey(pKouteiLockKey);

            UnassignTaskOutBean unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

            kekkaStatus = unassignTaskOutBean.getKekkastatus();
            syousaiMsgCd = unassignTaskOutBean.getSyousaimsgcd();

            if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            }
            else {
                throw new BizAppException(
                        MessageId.EBS0007, "業務共通強制タスク開始", "割当解除", syousaiMsgCd);
            }
        }

        StartTaskInBean startTaskInBean = new StartTaskInBean();

        startTaskInBean.setGyoumukey(pKouteiKanriId);
        startTaskInBean.setFlowid(pJimuTetuzukiCd);
        startTaskInBean.setAccountid(baseUserInfo.getUserId());
        startTaskInBean.setTaskname(pTaskId);
        startTaskInBean.setLockkey(pKouteiLockKey);

        StartTaskOutBean startTaskOutBean = iwfKouteiClient.execStartTask(startTaskInBean);

        kekkaStatus = startTaskOutBean.getKekkastatus();
        syousaiMsgCd = startTaskOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "業務共通強制タスク開始", "タスク開始", syousaiMsgCd);
        }
    }
}
