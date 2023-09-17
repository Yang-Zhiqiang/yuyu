package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_UserSettei;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_UserSettei;
import yuyu.def.db.meta.QAT_UserSettei;

public class SortAT_UserSettei {

    public List<AT_UserSettei> OrderAT_UserSetteiByPkAsc(List<AT_UserSettei> pEntity) {
        List<SortCondition<AT_UserSettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserSettei()).userId, SortOrder.ASC));
        List<AT_UserSettei> copyList = new ArrayList<AT_UserSettei>(pEntity);
        Collections.sort(copyList, new OrderAT_UserSettei(orders));
        return copyList;
    }

    public List<AT_UserSettei> OrderAT_UserSetteiByPkDesc(List<AT_UserSettei> pEntity) {
        List<SortCondition<AT_UserSettei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserSettei()).userId, SortOrder.DESC));
        List<AT_UserSettei> copyList = new ArrayList<AT_UserSettei>(pEntity);
        Collections.sort(copyList, new OrderAT_UserSettei(orders));
        return copyList;
    }
}
