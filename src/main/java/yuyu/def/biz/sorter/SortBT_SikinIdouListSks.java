package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_SikinIdouListSks;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.def.db.meta.QBT_SikinIdouListSks;

public class SortBT_SikinIdouListSks {

    public List<BT_SikinIdouListSks> OrderBT_SikinIdouListSksByPkAsc(List<BT_SikinIdouListSks> pEntity) {
        List<SortCondition<BT_SikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).edano, SortOrder.ASC));
        List<BT_SikinIdouListSks> copyList = new ArrayList<BT_SikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_SikinIdouListSks(orders));
        return copyList;
    }

    public List<BT_SikinIdouListSks> OrderBT_SikinIdouListSksByPkDesc(List<BT_SikinIdouListSks> pEntity) {
        List<SortCondition<BT_SikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_SikinIdouListSks()).edano, SortOrder.DESC));
        List<BT_SikinIdouListSks> copyList = new ArrayList<BT_SikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_SikinIdouListSks(orders));
        return copyList;
    }
}
