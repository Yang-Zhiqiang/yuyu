package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouKhMeigi;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.meta.QBT_IdouKhMeigi;

public class SortBT_IdouKhMeigi {

    public List<BT_IdouKhMeigi> OrderBT_IdouKhMeigiByPkAsc(List<BT_IdouKhMeigi> pEntity) {
        List<SortCondition<BT_IdouKhMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhMeigi()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouKhMeigi()).renno3keta, SortOrder.ASC));
        List<BT_IdouKhMeigi> copyList = new ArrayList<BT_IdouKhMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhMeigi(orders));
        return copyList;
    }

    public List<BT_IdouKhMeigi> OrderBT_IdouKhMeigiByPkDesc(List<BT_IdouKhMeigi> pEntity) {
        List<SortCondition<BT_IdouKhMeigi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhMeigi()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouKhMeigi()).renno3keta, SortOrder.DESC));
        List<BT_IdouKhMeigi> copyList = new ArrayList<BT_IdouKhMeigi>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhMeigi(orders));
        return copyList;
    }
}
