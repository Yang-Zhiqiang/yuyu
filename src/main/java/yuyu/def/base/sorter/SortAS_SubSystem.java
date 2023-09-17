package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_SubSystem;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.meta.QAS_SubSystem;

public class SortAS_SubSystem {

    public List<AS_SubSystem> OrderAS_SubSystemByPkAsc(List<AS_SubSystem> pEntity) {
        List<SortCondition<AS_SubSystem>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_SubSystem()).subSystemId, SortOrder.ASC));
        List<AS_SubSystem> copyList = new ArrayList<AS_SubSystem>(pEntity);
        Collections.sort(copyList, new OrderAS_SubSystem(orders));
        return copyList;
    }

    public List<AS_SubSystem> OrderAS_SubSystemByPkDesc(List<AS_SubSystem> pEntity) {
        List<SortCondition<AS_SubSystem>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_SubSystem()).subSystemId, SortOrder.DESC));
        List<AS_SubSystem> copyList = new ArrayList<AS_SubSystem>(pEntity);
        Collections.sort(copyList, new OrderAS_SubSystem(orders));
        return copyList;
    }

    public List<AS_SubSystem> OrderAS_SubSystemBySortNoAsc(List<AS_SubSystem> pEntity) {
        List<SortCondition<AS_SubSystem>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_SubSystem()).sortNo, SortOrder.ASC));
        List<AS_SubSystem> copyList = new ArrayList<AS_SubSystem>(pEntity);
        Collections.sort(copyList, new OrderAS_SubSystem(orders));
        return copyList;
    }
}
