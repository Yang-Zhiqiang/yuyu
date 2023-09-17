package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.meta.QBT_IdouKhBosyuudrItjhzn;

public class SortBT_IdouKhBosyuudrItjhzn {

    public List<BT_IdouKhBosyuudrItjhzn> OrderBT_IdouKhBosyuudrItjhznByPkAsc(List<BT_IdouKhBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouKhBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudrItjhzn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudrItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouKhBosyuudrItjhzn> copyList = new ArrayList<BT_IdouKhBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhBosyuudrItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouKhBosyuudrItjhzn> OrderBT_IdouKhBosyuudrItjhznByPkDesc(List<BT_IdouKhBosyuudrItjhzn> pEntity) {
        List<SortCondition<BT_IdouKhBosyuudrItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudrItjhzn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudrItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouKhBosyuudrItjhzn> copyList = new ArrayList<BT_IdouKhBosyuudrItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhBosyuudrItjhzn(orders));
        return copyList;
    }
}
