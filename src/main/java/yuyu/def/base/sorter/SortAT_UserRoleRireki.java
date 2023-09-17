package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_UserRoleRireki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.meta.QAT_UserRoleRireki;

public class SortAT_UserRoleRireki {

    public List<AT_UserRoleRireki> OrderAT_UserRoleRirekiByPkAsc(List<AT_UserRoleRireki> pEntity) {
        List<SortCondition<AT_UserRoleRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserRoleRireki()).uniqueId, SortOrder.ASC));
        List<AT_UserRoleRireki> copyList = new ArrayList<AT_UserRoleRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_UserRoleRireki(orders));
        return copyList;
    }

    public List<AT_UserRoleRireki> OrderAT_UserRoleRirekiByPkDesc(List<AT_UserRoleRireki> pEntity) {
        List<SortCondition<AT_UserRoleRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserRoleRireki()).uniqueId, SortOrder.DESC));
        List<AT_UserRoleRireki> copyList = new ArrayList<AT_UserRoleRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_UserRoleRireki(orders));
        return copyList;
    }
}
