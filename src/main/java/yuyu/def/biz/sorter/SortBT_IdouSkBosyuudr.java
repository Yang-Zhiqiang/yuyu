package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.meta.QBT_IdouSkBosyuudr;

public class SortBT_IdouSkBosyuudr {

    public List<BT_IdouSkBosyuudr> OrderBT_IdouSkBosyuudrByPkAsc(List<BT_IdouSkBosyuudr> pEntity) {
        List<SortCondition<BT_IdouSkBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudr()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudr()).renno3keta, SortOrder.ASC));
        List<BT_IdouSkBosyuudr> copyList = new ArrayList<BT_IdouSkBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkBosyuudr(orders));
        return copyList;
    }

    public List<BT_IdouSkBosyuudr> OrderBT_IdouSkBosyuudrByPkDesc(List<BT_IdouSkBosyuudr> pEntity) {
        List<SortCondition<BT_IdouSkBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudr()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouSkBosyuudr()).renno3keta, SortOrder.DESC));
        List<BT_IdouSkBosyuudr> copyList = new ArrayList<BT_IdouSkBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouSkBosyuudr(orders));
        return copyList;
    }

}

