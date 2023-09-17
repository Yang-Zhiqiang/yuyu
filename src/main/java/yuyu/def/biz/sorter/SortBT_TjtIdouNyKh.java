package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.meta.QBT_TjtIdouNyKh;

public class SortBT_TjtIdouNyKh {

    public List<BT_TjtIdouNyKh> OrderBT_TjtIdouNyKhByPkAsc(List<BT_TjtIdouNyKh> pEntity) {
        List<SortCondition<BT_TjtIdouNyKh>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKh()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKh()).renno3keta, SortOrder.ASC));
        List<BT_TjtIdouNyKh> copyList = new ArrayList<BT_TjtIdouNyKh>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyKh(orders));
        return copyList;
    }

    public List<BT_TjtIdouNyKh> OrderBT_TjtIdouNyKhByPkDesc(List<BT_TjtIdouNyKh> pEntity) {
        List<SortCondition<BT_TjtIdouNyKh>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKh()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TjtIdouNyKh()).renno3keta, SortOrder.DESC));
        List<BT_TjtIdouNyKh> copyList = new ArrayList<BT_TjtIdouNyKh>(pEntity);
        Collections.sort(copyList, new OrderBT_TjtIdouNyKh(orders));
        return copyList;
    }
}
