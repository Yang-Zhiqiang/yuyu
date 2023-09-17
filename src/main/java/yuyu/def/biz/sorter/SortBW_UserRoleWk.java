package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBW_UserRoleWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.meta.QBW_UserRoleWk;

public class SortBW_UserRoleWk {

    public List<BW_UserRoleWk> OrderBW_UserRoleWkByPkAsc(List<BW_UserRoleWk> pEntity) {
        List<SortCondition<BW_UserRoleWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserRoleWk()).userId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_UserRoleWk()).roleCd, SortOrder.ASC));
        List<BW_UserRoleWk> copyList = new ArrayList<BW_UserRoleWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserRoleWk(orders));
        return copyList;
    }

    public List<BW_UserRoleWk> OrderBW_UserRoleWkByPkDesc(List<BW_UserRoleWk> pEntity) {
        List<SortCondition<BW_UserRoleWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserRoleWk()).userId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_UserRoleWk()).roleCd, SortOrder.DESC));
        List<BW_UserRoleWk> copyList = new ArrayList<BW_UserRoleWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserRoleWk(orders));
        return copyList;
    }
}
