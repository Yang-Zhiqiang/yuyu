package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNySkItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNySkItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNySkItjhzn;

public class SortBT_TjtIdouNySkItjhzn {

    public List<BT_TjtIdouNySkItjhzn> OrderBT_TjtIdouNySkItjhznByPkAsc(List<BT_TjtIdouNySkItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNySkItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNySkItjhzn()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNySkItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNySkItjhzn> copyList = new ArrayList<BT_TjtIdouNySkItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNySkItjhzn(orders));
        return copyList;
    }

    public List<BT_TjtIdouNySkItjhzn> OrderBT_TjtIdouNySkItjhznByPkDesc(List<BT_TjtIdouNySkItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNySkItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNySkItjhzn()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNySkItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNySkItjhzn> copyList = new ArrayList<BT_TjtIdouNySkItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNySkItjhzn(orders));
        return copyList;
    }

}

