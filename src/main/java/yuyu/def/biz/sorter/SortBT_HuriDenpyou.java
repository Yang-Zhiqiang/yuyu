package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HuriDenpyou;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.meta.QBT_HuriDenpyou;

public class SortBT_HuriDenpyou {

    public List<BT_HuriDenpyou> OrderBT_HuriDenpyouByPkAsc(List<BT_HuriDenpyou> pEntity) {
        List<SortCondition<BT_HuriDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).edano, SortOrder.ASC));
        List<BT_HuriDenpyou> copyList = new ArrayList<BT_HuriDenpyou>(pEntity);
        Collections.sort(copyList, new OrderBT_HuriDenpyou(orders));
        return copyList;
    }

    public List<BT_HuriDenpyou> OrderBT_HuriDenpyouByPkDesc(List<BT_HuriDenpyou> pEntity) {
        List<SortCondition<BT_HuriDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HuriDenpyou()).edano, SortOrder.DESC));
        List<BT_HuriDenpyou> copyList = new ArrayList<BT_HuriDenpyou>(pEntity);
        Collections.sort(copyList, new OrderBT_HuriDenpyou(orders));
        return copyList;
    }

}

