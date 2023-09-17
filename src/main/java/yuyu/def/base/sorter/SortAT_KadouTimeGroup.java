package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_KadouTimeGroup;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.meta.QAT_KadouTimeGroup;

public class SortAT_KadouTimeGroup {

    public List<AT_KadouTimeGroup> OrderAT_KadouTimeGroupByPkAsc(List<AT_KadouTimeGroup> pEntity) {
        List<SortCondition<AT_KadouTimeGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KadouTimeGroup()).kadouTimeGroupCd, SortOrder.ASC));
        List<AT_KadouTimeGroup> copyList = new ArrayList<AT_KadouTimeGroup>(pEntity);
        Collections.sort(copyList, new OrderAT_KadouTimeGroup(orders));
        return copyList;
    }

    public List<AT_KadouTimeGroup> OrderAT_KadouTimeGroupByPkDesc(List<AT_KadouTimeGroup> pEntity) {
        List<SortCondition<AT_KadouTimeGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KadouTimeGroup()).kadouTimeGroupCd, SortOrder.DESC));
        List<AT_KadouTimeGroup> copyList = new ArrayList<AT_KadouTimeGroup>(pEntity);
        Collections.sort(copyList, new OrderAT_KadouTimeGroup(orders));
        return copyList;
    }
}
