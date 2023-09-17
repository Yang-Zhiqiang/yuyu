package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_UserIdKanren;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserIdKanren;

public class SortAT_UserIdKanren {

    public List<AT_UserIdKanren> OrderAT_UserIdKanrenByPkAsc(List<AT_UserIdKanren> pEntity) {
        List<SortCondition<AT_UserIdKanren>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserIdKanren()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_UserIdKanren()).idcd, SortOrder.ASC));
        List<AT_UserIdKanren> copyList = new ArrayList<AT_UserIdKanren>(pEntity);
        Collections.sort(copyList, new OrderAT_UserIdKanren(orders));
        return copyList;
    }

    public List<AT_UserIdKanren> OrderAT_UserIdKanrenByPkDesc(List<AT_UserIdKanren> pEntity) {
        List<SortCondition<AT_UserIdKanren>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_UserIdKanren()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_UserIdKanren()).idcd, SortOrder.DESC));
        List<AT_UserIdKanren> copyList = new ArrayList<AT_UserIdKanren>(pEntity);
        Collections.sort(copyList, new OrderAT_UserIdKanren(orders));
        return copyList;
    }
}
