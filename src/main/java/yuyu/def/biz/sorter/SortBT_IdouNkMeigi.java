package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouNkMeigi;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.meta.QBT_IdouNkMeigi;

public class SortBT_IdouNkMeigi {

    public List<BT_IdouNkMeigi> OrderBT_IdouNkMeigiByPkAsc(List<BT_IdouNkMeigi> pEntity) {
        List<SortCondition<BT_IdouNkMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkMeigi()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouNkMeigi()).renno3keta, SortOrder.ASC));
        List<BT_IdouNkMeigi> copyList = new ArrayList<BT_IdouNkMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkMeigi(orders));
        return copyList;
    }

    public List<BT_IdouNkMeigi> OrderBT_IdouNkMeigiByPkDesc(List<BT_IdouNkMeigi> pEntity) {
        List<SortCondition<BT_IdouNkMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkMeigi()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouNkMeigi()).renno3keta, SortOrder.DESC));
        List<BT_IdouNkMeigi> copyList = new ArrayList<BT_IdouNkMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkMeigi(orders));
        return copyList;
    }

}

