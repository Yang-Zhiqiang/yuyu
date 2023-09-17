package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouSkMeigi;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.meta.QBT_IdouSkMeigi;

public class SortBT_IdouSkMeigi {

    public List<BT_IdouSkMeigi> OrderBT_IdouSkMeigiByPkAsc(List<BT_IdouSkMeigi> pEntity) {
        List<SortCondition<BT_IdouSkMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkMeigi()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouSkMeigi()).renno3keta, SortOrder.ASC));
        List<BT_IdouSkMeigi> copyList = new ArrayList<BT_IdouSkMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkMeigi(orders));
        return copyList;
    }

    public List<BT_IdouSkMeigi> OrderBT_IdouSkMeigiByPkDesc(List<BT_IdouSkMeigi> pEntity) {
        List<SortCondition<BT_IdouSkMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkMeigi()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouSkMeigi()).renno3keta, SortOrder.DESC));
        List<BT_IdouSkMeigi> copyList = new ArrayList<BT_IdouSkMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkMeigi(orders));
        return copyList;
    }

}

