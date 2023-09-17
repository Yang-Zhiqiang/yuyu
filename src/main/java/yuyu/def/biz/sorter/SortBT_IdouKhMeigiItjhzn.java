package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouKhMeigiItjhzn;
import yuyu.def.db.entity.BT_IdouKhMeigiItjhzn;
import yuyu.def.db.meta.QBT_IdouKhMeigiItjhzn;

public class SortBT_IdouKhMeigiItjhzn {

    public List<BT_IdouKhMeigiItjhzn> OrderBT_IdouKhMeigiItjhznByPkAsc(List<BT_IdouKhMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouKhMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhMeigiItjhzn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouKhMeigiItjhzn()).renno3keta, SortOrder.ASC));
        List<BT_IdouKhMeigiItjhzn> copyList = new ArrayList<BT_IdouKhMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhMeigiItjhzn(orders));
        return copyList;
    }

    public List<BT_IdouKhMeigiItjhzn> OrderBT_IdouKhMeigiItjhznByPkDesc(List<BT_IdouKhMeigiItjhzn> pEntity) {
        List<SortCondition<BT_IdouKhMeigiItjhzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhMeigiItjhzn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouKhMeigiItjhzn()).renno3keta, SortOrder.DESC));
        List<BT_IdouKhMeigiItjhzn> copyList = new ArrayList<BT_IdouKhMeigiItjhzn>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhMeigiItjhzn(orders));
        return copyList;
    }
}
