package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_Role;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.meta.QAM_Role;

public class SortAM_Role {

    public List<AM_Role> OrderAM_RoleByPkAsc(List<AM_Role> pEntity) {
        List<SortCondition<AM_Role>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Role()).roleCd, SortOrder.ASC));
        List<AM_Role> copyList = new ArrayList<AM_Role>(pEntity);
        Collections.sort(copyList, new OrderAM_Role(orders));
        return copyList;
    }

    public List<AM_Role> OrderAM_RoleByPkDesc(List<AM_Role> pEntity) {
        List<SortCondition<AM_Role>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Role()).roleCd, SortOrder.DESC));
        List<AM_Role> copyList = new ArrayList<AM_Role>(pEntity);
        Collections.sort(copyList, new OrderAM_Role(orders));
        return copyList;
    }
}
