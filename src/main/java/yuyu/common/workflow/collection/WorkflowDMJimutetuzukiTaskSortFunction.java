package yuyu.common.workflow.collection;

import yuyu.def.db.entity.DM_JimutetuzukiTask;

import com.google.common.base.Function;

/**
 * 表示順をソート対象項目として返却します。 *
 */
public class WorkflowDMJimutetuzukiTaskSortFunction implements Function<DM_JimutetuzukiTask, Integer> {

    @Override
    public Integer apply(DM_JimutetuzukiTask jimutetudukiTask) {

        return jimutetudukiTask.getHyoujijyun();
    }
}
