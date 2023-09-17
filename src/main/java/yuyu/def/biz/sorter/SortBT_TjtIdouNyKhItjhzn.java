package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNyKhItjhzn;

public class SortBT_TjtIdouNyKhItjhzn {

    public List<BT_TjtIdouNyKhItjhzn> OrderBT_TjtIdouNyKhItjhznByPkAsc(List<BT_TjtIdouNyKhItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNyKhItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKhItjhzn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKhItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNyKhItjhzn> copyList = new ArrayList<BT_TjtIdouNyKhItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyKhItjhzn(orders));
        return copyList;
    }

    public List<BT_TjtIdouNyKhItjhzn> OrderBT_TjtIdouNyKhItjhznByPkDesc(List<BT_TjtIdouNyKhItjhzn> pEntity) {
        List<SortCondition<BT_TjtIdouNyKhItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKhItjhzn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKhItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNyKhItjhzn> copyList = new ArrayList<BT_TjtIdouNyKhItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyKhItjhzn(orders));
        return copyList;
    }
}
