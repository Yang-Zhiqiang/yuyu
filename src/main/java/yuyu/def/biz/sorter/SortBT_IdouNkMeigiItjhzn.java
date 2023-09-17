package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouNkMeigiItjhzn;
import yuyu.def.db.entity.BT_IdouNkMeigiItjhzn;
import yuyu.def.db.meta.QBT_IdouNkMeigiItjhzn;

public class SortBT_IdouNkMeigiItjhzn {

    public List<BT_IdouNkMeigiItjhzn> OrderBT_IdouNkMeigiItjhznByPkAsc(List<BT_IdouNkMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouNkMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkMeigiItjhzn()).nksysyno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouNkMeigiItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouNkMeigiItjhzn> copyList = new ArrayList<BT_IdouNkMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkMeigiItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouNkMeigiItjhzn> OrderBT_IdouNkMeigiItjhznByPkDesc(List<BT_IdouNkMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouNkMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouNkMeigiItjhzn()).nksysyno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouNkMeigiItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouNkMeigiItjhzn> copyList = new ArrayList<BT_IdouNkMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouNkMeigiItjhzn(orders));
        return copyList;
    }

}

