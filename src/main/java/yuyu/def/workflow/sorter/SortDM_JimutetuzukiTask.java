package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.meta.QDM_JimutetuzukiTask;
import yuyu.def.workflow.comparator.OrderDM_JimutetuzukiTask;

public class SortDM_JimutetuzukiTask {

    public List<DM_JimutetuzukiTask> OrderDM_JimutetuzukiTaskByPkAsc(List<DM_JimutetuzukiTask> pEntity) {
        List<SortCondition<DM_JimutetuzukiTask>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).workflowTskId, SortOrder.ASC));
        List<DM_JimutetuzukiTask> copyList = new ArrayList<DM_JimutetuzukiTask>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiTask(orders));
        return copyList;
    }

    public List<DM_JimutetuzukiTask> OrderDM_JimutetuzukiTaskByPkDesc(List<DM_JimutetuzukiTask> pEntity) {
        List<SortCondition<DM_JimutetuzukiTask>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).workflowTskId, SortOrder.DESC));
        List<DM_JimutetuzukiTask> copyList = new ArrayList<DM_JimutetuzukiTask>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiTask(orders));
        return copyList;
    }

    public List<DM_JimutetuzukiTask> OrderDM_JimutetuzukiTaskByJimutetuzukicdHyoujijyunAsc(List<DM_JimutetuzukiTask> pEntity) {
        List<SortCondition<DM_JimutetuzukiTask>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTask()).hyoujijyun, SortOrder.ASC));
        List<DM_JimutetuzukiTask> copyList = new ArrayList<DM_JimutetuzukiTask>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiTask(orders));
        return copyList;
    }


}

