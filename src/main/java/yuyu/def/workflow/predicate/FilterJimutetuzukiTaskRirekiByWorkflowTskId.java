package yuyu.def.workflow.predicate;

import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;

import com.google.common.base.Predicate;

/**
 * 事務手続タスクマスタ履歴保存テーブル用 Predicate<br/>
 */
public class FilterJimutetuzukiTaskRirekiByWorkflowTskId implements Predicate<DM_JimutetuzukiTaskRireki>{

    String workflowTskId;

    public FilterJimutetuzukiTaskRirekiByWorkflowTskId(String pWorkflowTskId){
        super();
        workflowTskId = pWorkflowTskId;
    }

    @Override
    public boolean apply(DM_JimutetuzukiTaskRireki pJimutetuzukiTaskRireki) {
        if(workflowTskId.equals(pJimutetuzukiTaskRireki.getWorkflowTskId())){
            return true;
        }
        return false;
    }
}
