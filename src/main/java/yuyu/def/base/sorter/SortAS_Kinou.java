package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_Kinou;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.meta.QAS_Kinou;

public class SortAS_Kinou {

    public List<AS_Kinou> OrderAS_KinouByPkAsc(List<AS_Kinou> pEntity) {
        List<SortCondition<AS_Kinou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Kinou()).kinouId, SortOrder.ASC));
        List<AS_Kinou> copyList = new ArrayList<AS_Kinou>(pEntity);
        Collections.sort(copyList, new OrderAS_Kinou(orders));
        return copyList;
    }

    public List<AS_Kinou> OrderAS_KinouByPkDesc(List<AS_Kinou> pEntity) {
        List<SortCondition<AS_Kinou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Kinou()).kinouId, SortOrder.DESC));
        List<AS_Kinou> copyList = new ArrayList<AS_Kinou>(pEntity);
        Collections.sort(copyList, new OrderAS_Kinou(orders));
        return copyList;
    }
}
