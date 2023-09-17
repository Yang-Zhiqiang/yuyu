package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.meta.QBT_IdouSkBosyuudrItjhzn;

public class SortBT_IdouSkBosyuudrItjhzn {

    public List<BT_IdouSkBosyuudrItjhzn> OrderBT_IdouSkBosyuudrItjhznByPkAsc(List<BT_IdouSkBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouSkBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudrItjhzn()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudrItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouSkBosyuudrItjhzn> copyList = new ArrayList<BT_IdouSkBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkBosyuudrItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouSkBosyuudrItjhzn> OrderBT_IdouSkBosyuudrItjhznByPkDesc(List<BT_IdouSkBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouSkBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudrItjhzn()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudrItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouSkBosyuudrItjhzn> copyList = new ArrayList<BT_IdouSkBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkBosyuudrItjhzn(orders));
        return copyList;
    }

}

