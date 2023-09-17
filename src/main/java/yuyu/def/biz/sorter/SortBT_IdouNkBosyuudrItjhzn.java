package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouNkBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouNkBosyuudrItjhzn;
import yuyu.def.db.meta.QBT_IdouNkBosyuudrItjhzn;

public class SortBT_IdouNkBosyuudrItjhzn {

    public List<BT_IdouNkBosyuudrItjhzn> OrderBT_IdouNkBosyuudrItjhznByPkAsc(List<BT_IdouNkBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouNkBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudrItjhzn()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudrItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouNkBosyuudrItjhzn> copyList = new ArrayList<BT_IdouNkBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkBosyuudrItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouNkBosyuudrItjhzn> OrderBT_IdouNkBosyuudrItjhznByPkDesc(List<BT_IdouNkBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouNkBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudrItjhzn()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudrItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouNkBosyuudrItjhzn> copyList = new ArrayList<BT_IdouNkBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkBosyuudrItjhzn(orders));
        return copyList;
    }

}

