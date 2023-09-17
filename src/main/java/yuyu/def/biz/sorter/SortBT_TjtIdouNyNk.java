package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.meta.QBT_TjtIdouNyNk;

public class SortBT_TjtIdouNyNk {

    public List<BT_TjtIdouNyNk> OrderBT_TjtIdouNyNkByPkAsc(List<BT_TjtIdouNyNk> pEntity) {
        List<SortCondition<BT_TjtIdouNyNk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNk()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNk()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNyNk> copyList = new ArrayList<BT_TjtIdouNyNk>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyNk(orders));
        return copyList;
    }

    public List<BT_TjtIdouNyNk> OrderBT_TjtIdouNyNkByPkDesc(List<BT_TjtIdouNyNk> pEntity) {
        List<SortCondition<BT_TjtIdouNyNk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNk()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNk()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNyNk> copyList = new ArrayList<BT_TjtIdouNyNk>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyNk(orders));
        return copyList;
    }

}

