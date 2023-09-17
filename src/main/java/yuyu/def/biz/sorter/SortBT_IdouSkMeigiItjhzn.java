package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouSkMeigiItjhzn;
import yuyu.def.db.entity.BT_IdouSkMeigiItjhzn;
import yuyu.def.db.meta.QBT_IdouSkMeigiItjhzn;

public class SortBT_IdouSkMeigiItjhzn {

    public List<BT_IdouSkMeigiItjhzn> OrderBT_IdouSkMeigiItjhznByPkAsc(List<BT_IdouSkMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouSkMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkMeigiItjhzn()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouSkMeigiItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouSkMeigiItjhzn> copyList = new ArrayList<BT_IdouSkMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkMeigiItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouSkMeigiItjhzn> OrderBT_IdouSkMeigiItjhznByPkDesc(List<BT_IdouSkMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouSkMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkMeigiItjhzn()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouSkMeigiItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouSkMeigiItjhzn> copyList = new ArrayList<BT_IdouSkMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkMeigiItjhzn(orders));
        return copyList;
    }

}

