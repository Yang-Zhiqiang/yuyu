package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_NenkinInfoRendou;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import yuyu.def.db.meta.QBT_NenkinInfoRendou;

public class SortBT_NenkinInfoRendou {

    public List<BT_NenkinInfoRendou> OrderBT_NenkinInfoRendouByPkAsc(List<BT_NenkinInfoRendou> pEntity) {
        List<SortCondition<BT_NenkinInfoRendou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).renno, SortOrder.ASC));
        List<BT_NenkinInfoRendou> copyList = new ArrayList<BT_NenkinInfoRendou>(pEntity);
        Collections.sort(copyList, new OrderBT_NenkinInfoRendou(orders));
        return copyList;
    }

    public List<BT_NenkinInfoRendou> OrderBT_NenkinInfoRendouByPkDesc(List<BT_NenkinInfoRendou> pEntity) {
        List<SortCondition<BT_NenkinInfoRendou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_NenkinInfoRendou()).renno, SortOrder.DESC));
        List<BT_NenkinInfoRendou> copyList = new ArrayList<BT_NenkinInfoRendou>(pEntity);
        Collections.sort(copyList, new OrderBT_NenkinInfoRendou(orders));
        return copyList;
    }

}

