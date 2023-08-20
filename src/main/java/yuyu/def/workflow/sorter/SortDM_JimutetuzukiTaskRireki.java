package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiTaskRireki;
import yuyu.def.workflow.comparator.OrderDM_JimutetuzukiTaskRireki;

public class SortDM_JimutetuzukiTaskRireki {

    public List<DM_JimutetuzukiTaskRireki> OrderDM_JimutetuzukiTaskRirekiByPkAsc(List<DM_JimutetuzukiTaskRireki> pEntity) {
        List<SortCondition<DM_JimutetuzukiTaskRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).kensuuHokanYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).workflowTskId, SortOrder.ASC));
        List<DM_JimutetuzukiTaskRireki> copyList = new ArrayList<DM_JimutetuzukiTaskRireki>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiTaskRireki(orders));
        return copyList;
    }

    public List<DM_JimutetuzukiTaskRireki> OrderDM_JimutetuzukiTaskRirekiByPkDesc(List<DM_JimutetuzukiTaskRireki> pEntity) {
        List<SortCondition<DM_JimutetuzukiTaskRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).kensuuHokanYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiTaskRireki()).workflowTskId, SortOrder.DESC));
        List<DM_JimutetuzukiTaskRireki> copyList = new ArrayList<DM_JimutetuzukiTaskRireki>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiTaskRireki(orders));
        return copyList;
    }
}
