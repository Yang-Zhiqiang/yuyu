package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_YendthnkSikinIdouListSks;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouListSks;

public class SortBT_YendthnkSikinIdouListSks {

    public List<BT_YendthnkSikinIdouListSks> OrderBT_YendthnkSikinIdouListSksByPkAsc(List<BT_YendthnkSikinIdouListSks> pEntity) {
        List<SortCondition<BT_YendthnkSikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).keiriyendthnkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).syoriYmd, SortOrder.ASC));
        List<BT_YendthnkSikinIdouListSks> copyList = new ArrayList<BT_YendthnkSikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_YendthnkSikinIdouListSks(orders));
        return copyList;
    }

    public List<BT_YendthnkSikinIdouListSks> OrderBT_YendthnkSikinIdouListSksByPkDesc(List<BT_YendthnkSikinIdouListSks> pEntity) {
        List<SortCondition<BT_YendthnkSikinIdouListSks>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).keiriyendthnkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_YendthnkSikinIdouListSks()).syoriYmd, SortOrder.DESC));
        List<BT_YendthnkSikinIdouListSks> copyList = new ArrayList<BT_YendthnkSikinIdouListSks>(pEntity);
        Collections.sort(copyList, new OrderBT_YendthnkSikinIdouListSks(orders));
        return copyList;
    }
}
