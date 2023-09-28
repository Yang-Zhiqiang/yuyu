package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksOutBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.result.bean.JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean;

/**
 * 業務共通 共通 業務共通実行可能タスク情報取得クラス
 */
public class BzGetExecutableTasks {

    @Inject
    private static Logger logger;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzGetExecutableTasks() {
        super();
    }

    public BzGetExecutableTasksOutBean exec(String pUserId) {

        logger.debug("▽ 業務共通実行可能タスク情報取得 開始");

        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = SWAKInjector.
            getInstance(BzGetExecutableTasksOutBean.class);

        List<BzGetExecutableTasksBean> bzGetExecutableTasksBeanList = new ArrayList<>();

        GetExecutableTasksInBean getExecutableTasksInBean = SWAKInjector.getInstance(GetExecutableTasksInBean.class);

        getExecutableTasksInBean.setAccountid(pUserId);

        getExecutableTasksInBean.seKensuuSyutokuYouhi("0");

        GetExecutableTasksOutBean getExecutableTasksOutBean = iwfKouteiClient.
            execGetExecutableTasks(getExecutableTasksInBean);

        if ("0".equals(getExecutableTasksOutBean.getKekkastatus())
            || (("9".equals(getExecutableTasksOutBean.getKekkastatus()))
                && IwfMessageCd.IWF2070.toString().equals(getExecutableTasksOutBean.getSyousaimsgcd()))) {

            bzGetExecutableTasksOutBean.setSyoriKekkaStatus("0");

        }
        else {
            bzGetExecutableTasksOutBean.setSyoriKekkaStatus(getExecutableTasksOutBean.getKekkastatus());

        }

        bzGetExecutableTasksOutBean.setSyousaiMessageCd(getExecutableTasksOutBean.getSyousaimsgcd());

        bzGetExecutableTasksOutBean.setSyousaiMessage(getExecutableTasksOutBean.getSyousaimsg());

        if (getExecutableTasksOutBean.getExecutableTaskInfos().size() != 0) {

            String[] flowId1_ = new String[getExecutableTasksOutBean.getExecutableTaskInfos().size()];

            String[] sNodeName_ = new String[getExecutableTasksOutBean.getExecutableTaskInfos().size()];

            for (int n = 0; n < getExecutableTasksOutBean.getExecutableTaskInfos().size(); n++) {

                flowId1_[n] = getExecutableTasksOutBean.getExecutableTaskInfos().get(n).getFlowId();

                sNodeName_[n] = getExecutableTasksOutBean.getExecutableTaskInfos().get(n).getNodeName();
            }

            List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean>
            JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList =
            workflowDomManager.getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(flowId1_, sNodeName_);

            for (int n = 0; n < JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.size(); n++) {

                BzGetExecutableTasksBean bzGetExecutableTasksBean = SWAKInjector.
                    getInstance(BzGetExecutableTasksBean.class);

                bzGetExecutableTasksBean.setSubSystemId(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n).
                    getAS_SubSystem().getSubSystemId());

                bzGetExecutableTasksBean.setSubSystemNm(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n).
                    getAS_SubSystem().getSubSystemNm());

                bzGetExecutableTasksBean.setJimutetuzukiCd(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n)
                    .getDM_Jimutetuzuki().getJimutetuzukicd());

                bzGetExecutableTasksBean.setJimutetuzukiNm(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n)
                    .getDM_Jimutetuzuki().getJimutetuzukinm());

                bzGetExecutableTasksBean.setTskId(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n).
                    getDM_JimutetuzukiTask().getWorkflowTskId());

                bzGetExecutableTasksBean.setTskNm(JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBeanList.get(n).
                    getDM_JimutetuzukiTask().getWorkflowTskNm());

                bzGetExecutableTasksBeanList.add(bzGetExecutableTasksBean);
            }
        }

        bzGetExecutableTasksOutBean.setBzGetExecutableTasksBeanList(bzGetExecutableTasksBeanList);

        logger.debug("△  業務共通実行可能タスク情報取得 終了");

        return bzGetExecutableTasksOutBean;

    }
}