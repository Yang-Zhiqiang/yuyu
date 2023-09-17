package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNyNkItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNyNkItjhzn;

public class SortBT_TjtIdouNyNkItjhzn {

    public List<BT_TjtIdouNyNkItjhzn> OrderBT_TjtIdouNyNkItjhznByPkAsc(List<BT_TjtIdouNyNkItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNyNkItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNkItjhzn()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNkItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNyNkItjhzn> copyList = new ArrayList<BT_TjtIdouNyNkItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyNkItjhzn(orders));
        return copyList;
    }

    public List<BT_TjtIdouNyNkItjhzn> OrderBT_TjtIdouNyNkItjhznByPkDesc(List<BT_TjtIdouNyNkItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNyNkItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNkItjhzn()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyNkItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNyNkItjhzn> copyList = new ArrayList<BT_TjtIdouNyNkItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyNkItjhzn(orders));
        return copyList;
    }

}

