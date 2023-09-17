package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNySk;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.meta.QBT_TjtIdouNySk;

public class SortBT_TjtIdouNySk {

    public List<BT_TjtIdouNySk> OrderBT_TjtIdouNySkByPkAsc(List<BT_TjtIdouNySk> pEntity) {
        List<SortCondition<BT_TjtIdouNySk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNySk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNySk()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNySk> copyList = new ArrayList<BT_TjtIdouNySk>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNySk(orders));
        return copyList;
    }

    public List<BT_TjtIdouNySk> OrderBT_TjtIdouNySkByPkDesc(List<BT_TjtIdouNySk> pEntity) {
        List<SortCondition<BT_TjtIdouNySk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNySk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNySk()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNySk> copyList = new ArrayList<BT_TjtIdouNySk>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNySk(orders));
        return copyList;
    }

}

