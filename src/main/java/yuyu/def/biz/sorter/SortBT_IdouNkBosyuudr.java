package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.meta.QBT_IdouNkBosyuudr;

public class SortBT_IdouNkBosyuudr {

    public List<BT_IdouNkBosyuudr> OrderBT_IdouNkBosyuudrByPkAsc(List<BT_IdouNkBosyuudr> pEntity) {
        List<SortCondition<BT_IdouNkBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudr()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudr()).renno3keta, SortOrder.ASC));
        List<BT_IdouNkBosyuudr> copyList = new ArrayList<BT_IdouNkBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkBosyuudr(orders));
        return copyList;
    }

    public List<BT_IdouNkBosyuudr> OrderBT_IdouNkBosyuudrByPkDesc(List<BT_IdouNkBosyuudr> pEntity) {
        List<SortCondition<BT_IdouNkBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudr()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouNkBosyuudr()).renno3keta, SortOrder.DESC));
        List<BT_IdouNkBosyuudr> copyList = new ArrayList<BT_IdouNkBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkBosyuudr(orders));
        return copyList;
    }

}

