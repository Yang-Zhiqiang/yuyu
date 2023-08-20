package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiRireki;
import yuyu.def.workflow.comparator.OrderDM_JimutetuzukiRireki;

public class SortDM_JimutetuzukiRireki {

    public List<DM_JimutetuzukiRireki> OrderDM_JimutetuzukiRirekiByPkAsc(List<DM_JimutetuzukiRireki> pEntity) {
        List<SortCondition<DM_JimutetuzukiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).kensuuHokanYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).subSystemId, SortOrder.ASC));
        List<DM_JimutetuzukiRireki> copyList = new ArrayList<DM_JimutetuzukiRireki>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiRireki(orders));
        return copyList;
    }

    public List<DM_JimutetuzukiRireki> OrderDM_JimutetuzukiRirekiByPkDesc(List<DM_JimutetuzukiRireki> pEntity) {
        List<SortCondition<DM_JimutetuzukiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).kensuuHokanYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_JimutetuzukiRireki()).subSystemId, SortOrder.DESC));
        List<DM_JimutetuzukiRireki> copyList = new ArrayList<DM_JimutetuzukiRireki>(pEntity);
        Collections.sort(copyList, new OrderDM_JimutetuzukiRireki(orders));
        return copyList;
    }
}
