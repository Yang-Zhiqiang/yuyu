package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.meta.QBT_IdouKhBosyuudr;

public class SortBT_IdouKhBosyuudr {

    public List<BT_IdouKhBosyuudr> OrderBT_IdouKhBosyuudrByPkAsc(List<BT_IdouKhBosyuudr> pEntity) {
        List<SortCondition<BT_IdouKhBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudr()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudr()).renno3keta, SortOrder.ASC));
        List<BT_IdouKhBosyuudr> copyList = new ArrayList<BT_IdouKhBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhBosyuudr(orders));
        return copyList;
    }

    public List<BT_IdouKhBosyuudr> OrderBT_IdouKhBosyuudrByPkDesc(List<BT_IdouKhBosyuudr> pEntity) {
        List<SortCondition<BT_IdouKhBosyuudr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudr()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_IdouKhBosyuudr()).renno3keta, SortOrder.DESC));
        List<BT_IdouKhBosyuudr> copyList = new ArrayList<BT_IdouKhBosyuudr>(pEntity);
        Collections.sort(copyList, new OrderBT_IdouKhBosyuudr(orders));
        return copyList;
    }
}
