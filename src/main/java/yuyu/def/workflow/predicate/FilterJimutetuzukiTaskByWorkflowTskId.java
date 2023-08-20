package yuyu.def.workflow.predicate;

import yuyu.def.db.entity.DM_JimutetuzukiTask;

import com.google.common.base.Predicate;

/**
 * 事務手続タスクマスタ用 Predicate<br/>
 */
public class FilterJimutetuzukiTaskByWorkflowTskId implements Predicate<DM_JimutetuzukiTask>{
    String workflowTskId;

    public FilterJimutetuzukiTaskByWorkflowTskId(String pWorkflowTskId){
        super();
        workflowTskId = pWorkflowTskId;
    }

    @Override
    public boolean apply(DM_JimutetuzukiTask pJimutetuzukiTask) {
        if(workflowTskId.equals(pJimutetuzukiTask.getWorkflowTskId())){
            return true;
        }
        return false;
    }
}
