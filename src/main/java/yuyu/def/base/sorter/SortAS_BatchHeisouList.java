package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_BatchHeisouList;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.meta.QAS_BatchHeisouList;

public class SortAS_BatchHeisouList {

    public List<AS_BatchHeisouList> OrderAS_BatchHeisouListByPkAsc(List<AS_BatchHeisouList> pEntity) {
        List<SortCondition<AS_BatchHeisouList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_BatchHeisouList()).selfKinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAS_BatchHeisouList()).targetKinouId, SortOrder.ASC));
        List<AS_BatchHeisouList> copyList = new ArrayList<AS_BatchHeisouList>(pEntity);
        Collections.sort(copyList, new OrderAS_BatchHeisouList(orders));
        return copyList;
    }

    public List<AS_BatchHeisouList> OrderAS_BatchHeisouListByPkDesc(List<AS_BatchHeisouList> pEntity) {
        List<SortCondition<AS_BatchHeisouList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_BatchHeisouList()).selfKinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAS_BatchHeisouList()).targetKinouId, SortOrder.DESC));
        List<AS_BatchHeisouList> copyList = new ArrayList<AS_BatchHeisouList>(pEntity);
        Collections.sort(copyList, new OrderAS_BatchHeisouList(orders));
        return copyList;
    }
}
