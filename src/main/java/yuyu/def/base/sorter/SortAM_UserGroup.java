package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_UserGroup;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.meta.QAM_UserGroup;

public class SortAM_UserGroup {

    public List<AM_UserGroup> OrderAM_UserGroupByPkAsc(List<AM_UserGroup> pEntity) {
        List<SortCondition<AM_UserGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_UserGroup()).userGroupCd, SortOrder.ASC));
        List<AM_UserGroup> copyList = new ArrayList<AM_UserGroup>(pEntity);
        Collections.sort(copyList, new OrderAM_UserGroup(orders));
        return copyList;
    }

    public List<AM_UserGroup> OrderAM_UserGroupByPkDesc(List<AM_UserGroup> pEntity) {
        List<SortCondition<AM_UserGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_UserGroup()).userGroupCd, SortOrder.DESC));
        List<AM_UserGroup> copyList = new ArrayList<AM_UserGroup>(pEntity);
        Collections.sort(copyList, new OrderAM_UserGroup(orders));
        return copyList;
    }
}
