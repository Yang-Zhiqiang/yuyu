package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_UserRole;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.meta.QAT_UserRole;

public class SortAT_UserRole {

    public List<AT_UserRole> OrderAT_UserRoleByPkAsc(List<AT_UserRole> pEntity) {
        List<SortCondition<AT_UserRole>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserRole()).userId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_UserRole()).roleCd, SortOrder.ASC));
        List<AT_UserRole> copyList = new ArrayList<AT_UserRole>(pEntity);
        Collections.sort(copyList, new OrderAT_UserRole(orders));
        return copyList;
    }

    public List<AT_UserRole> OrderAT_UserRoleByPkDesc(List<AT_UserRole> pEntity) {
        List<SortCondition<AT_UserRole>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserRole()).userId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_UserRole()).roleCd, SortOrder.DESC));
        List<AT_UserRole> copyList = new ArrayList<AT_UserRole>(pEntity);
        Collections.sort(copyList, new OrderAT_UserRole(orders));
        return copyList;
    }
}
