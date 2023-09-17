package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;

public class SortBW_UserIdKanrenWk {

    public List<BW_UserIdKanrenWk> OrderBW_UserIdKanrenWkByPkAsc(List<BW_UserIdKanrenWk> pEntity) {
        List<SortCondition<BW_UserIdKanrenWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserIdKanrenWk()).idkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBW_UserIdKanrenWk()).idcd, SortOrder.ASC));
        List<BW_UserIdKanrenWk> copyList = new ArrayList<BW_UserIdKanrenWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserIdKanrenWk(orders));
        return copyList;
    }

    public List<BW_UserIdKanrenWk> OrderBW_UserIdKanrenWkByPkDesc(List<BW_UserIdKanrenWk> pEntity) {
        List<SortCondition<BW_UserIdKanrenWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBW_UserIdKanrenWk()).idkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBW_UserIdKanrenWk()).idcd, SortOrder.DESC));
        List<BW_UserIdKanrenWk> copyList = new ArrayList<BW_UserIdKanrenWk>(pEntity);
        Collections.sort(copyList, new OrderBW_UserIdKanrenWk(orders));
        return copyList;
    }
}
