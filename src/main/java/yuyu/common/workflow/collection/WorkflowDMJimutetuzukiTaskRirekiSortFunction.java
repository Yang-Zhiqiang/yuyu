package yuyu.common.workflow.collection;

import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;

import com.google.common.base.Function;

/**
 * 表示順をソート対象項目として返却します。 *
 */
public class WorkflowDMJimutetuzukiTaskRirekiSortFunction implements Function<DM_JimutetuzukiTaskRireki, Integer> {

    @Override
    public Integer apply(DM_JimutetuzukiTaskRireki jimutetudukiTaskRireki) {

        return jimutetudukiTaskRireki.getHyoujijyun();
    }
}
