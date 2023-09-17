package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_User;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.meta.QAM_User;

public class SortAM_User {

    public List<AM_User> OrderAM_UserByPkAsc(List<AM_User> pEntity) {
        List<SortCondition<AM_User>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_User()).userId, SortOrder.ASC));
        List<AM_User> copyList = new ArrayList<AM_User>(pEntity);
        Collections.sort(copyList, new OrderAM_User(orders));
        return copyList;
    }

    public List<AM_User> OrderAM_UserByPkDesc(List<AM_User> pEntity) {
        List<SortCondition<AM_User>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_User()).userId, SortOrder.DESC));
        List<AM_User> copyList = new ArrayList<AM_User>(pEntity);
        Collections.sort(copyList, new OrderAM_User(orders));
        return copyList;
    }
}
