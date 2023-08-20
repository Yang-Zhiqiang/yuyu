package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.meta.QDM_Jimutetuzuki;
import yuyu.def.workflow.comparator.OrderDM_Jimutetuzuki;

public class SortDM_Jimutetuzuki {

    public List<DM_Jimutetuzuki> OrderDM_JimutetuzukiByPkAsc(List<DM_Jimutetuzuki> pEntity) {
        List<SortCondition<DM_Jimutetuzuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_Jimutetuzuki()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDM_Jimutetuzuki()).subSystemId, SortOrder.ASC));
        List<DM_Jimutetuzuki> copyList = new ArrayList<DM_Jimutetuzuki>(pEntity);
        Collections.sort(copyList, new OrderDM_Jimutetuzuki(orders));
        return copyList;
    }

    public List<DM_Jimutetuzuki> OrderDM_JimutetuzukiByPkDesc(List<DM_Jimutetuzuki> pEntity) {
        List<SortCondition<DM_Jimutetuzuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_Jimutetuzuki()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDM_Jimutetuzuki()).subSystemId, SortOrder.DESC));
        List<DM_Jimutetuzuki> copyList = new ArrayList<DM_Jimutetuzuki>(pEntity);
        Collections.sort(copyList, new OrderDM_Jimutetuzuki(orders));
        return copyList;
    }

    public List<DM_Jimutetuzuki> OrderDM_JimutetuzukiByHyoujijyunAsc(List<DM_Jimutetuzuki> pEntity) {
        List<SortCondition<DM_Jimutetuzuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDM_Jimutetuzuki()).hyoujijyun, SortOrder.ASC));
        List<DM_Jimutetuzuki> copyList = new ArrayList<DM_Jimutetuzuki>(pEntity);
        Collections.sort(copyList, new OrderDM_Jimutetuzuki(orders));
        return copyList;
    }


}

