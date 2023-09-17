package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_BatchOrder;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.meta.QAS_BatchOrder;

public class SortAS_BatchOrder {

    public List<AS_BatchOrder> OrderAS_BatchOrderByPkAsc(List<AS_BatchOrder> pEntity) {
        List<SortCondition<AS_BatchOrder>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_BatchOrder()).batchJobId, SortOrder.ASC));
        List<AS_BatchOrder> copyList = new ArrayList<AS_BatchOrder>(pEntity);
        Collections.sort(copyList, new OrderAS_BatchOrder(orders));
        return copyList;
    }

    public List<AS_BatchOrder> OrderAS_BatchOrderByPkDesc(List<AS_BatchOrder> pEntity) {
        List<SortCondition<AS_BatchOrder>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_BatchOrder()).batchJobId, SortOrder.DESC));
        List<AS_BatchOrder> copyList = new ArrayList<AS_BatchOrder>(pEntity);
        Collections.sort(copyList, new OrderAS_BatchOrder(orders));
        return copyList;
    }
}
