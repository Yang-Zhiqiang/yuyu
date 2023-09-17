package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBW_UserWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.def.db.meta.QBW_UserWk;

public class SortBW_UserWk {

    public List<BW_UserWk> OrderBW_UserWkByPkAsc(List<BW_UserWk> pEntity) {
        List<SortCondition<BW_UserWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserWk()).userId, SortOrder.ASC));
        List<BW_UserWk> copyList = new ArrayList<BW_UserWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserWk(orders));
        return copyList;
    }

    public List<BW_UserWk> OrderBW_UserWkByPkDesc(List<BW_UserWk> pEntity) {
        List<SortCondition<BW_UserWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserWk()).userId, SortOrder.DESC));
        List<BW_UserWk> copyList = new ArrayList<BW_UserWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserWk(orders));
        return copyList;
    }
}
