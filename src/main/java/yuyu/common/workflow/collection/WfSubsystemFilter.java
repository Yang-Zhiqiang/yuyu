package yuyu.common.workflow.collection;

import yuyu.common.biz.bzcommon.BzGetExecutableTasksBean;

import com.google.common.base.Predicate;

/**
 * イメージワークフローで表示可能なサブシステムの絞り込みを行う。<br/>
 */
public class WfSubsystemFilter implements Predicate<BzGetExecutableTasksBean> {

    @Override
    public boolean apply(BzGetExecutableTasksBean tasksBean) {
        if (WorkflowSubsystemConstants.E_SubSystem.SINKEIYAKU.getSubSystemId().equals(tasksBean.getSubSystemId())||
            WorkflowSubsystemConstants.E_SubSystem.KEIYAKUHOZEN.getSubSystemId().equals(tasksBean.getSubSystemId())||
            WorkflowSubsystemConstants.E_SubSystem.HOKENKYUHUSIHARAI.getSubSystemId().equals(tasksBean.getSubSystemId())||
            WorkflowSubsystemConstants.E_SubSystem.NENKINSIHARAI.getSubSystemId().equals(tasksBean.getSubSystemId())
            ) {
            return true;
        }
        return false;
    }

}
