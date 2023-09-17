package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_SosikiRole;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.meta.QAT_SosikiRole;

public class SortAT_SosikiRole {

    public List<AT_SosikiRole> OrderAT_SosikiRoleByPkAsc(List<AT_SosikiRole> pEntity) {
        List<SortCondition<AT_SosikiRole>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SosikiRole()).tanmatusettisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_SosikiRole()).roleCd, SortOrder.ASC));
        List<AT_SosikiRole> copyList = new ArrayList<AT_SosikiRole>(pEntity);
        Collections.sort(copyList, new OrderAT_SosikiRole(orders));
        return copyList;
    }

    public List<AT_SosikiRole> OrderAT_SosikiRoleByPkDesc(List<AT_SosikiRole> pEntity) {
        List<SortCondition<AT_SosikiRole>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SosikiRole()).tanmatusettisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_SosikiRole()).roleCd, SortOrder.DESC));
        List<AT_SosikiRole> copyList = new ArrayList<AT_SosikiRole>(pEntity);
        Collections.sort(copyList, new OrderAT_SosikiRole(orders));
        return copyList;
    }
}
