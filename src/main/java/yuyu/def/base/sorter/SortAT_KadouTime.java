package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_KadouTime;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.meta.QAT_KadouTime;

public class SortAT_KadouTime {

    public List<AT_KadouTime> OrderAT_KadouTimeByPkAsc(List<AT_KadouTime> pEntity) {
        List<SortCondition<AT_KadouTime>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KadouTime()).kadouTimeGroupCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KadouTime()).kadouTimeYoubiKbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KadouTime()).eigyoubiKbn, SortOrder.ASC));
        List<AT_KadouTime> copyList = new ArrayList<AT_KadouTime>(pEntity);
        Collections.sort(copyList, new OrderAT_KadouTime(orders));
        return copyList;
    }

    public List<AT_KadouTime> OrderAT_KadouTimeByPkDesc(List<AT_KadouTime> pEntity) {
        List<SortCondition<AT_KadouTime>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KadouTime()).kadouTimeGroupCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KadouTime()).kadouTimeYoubiKbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KadouTime()).eigyoubiKbn, SortOrder.DESC));
        List<AT_KadouTime> copyList = new ArrayList<AT_KadouTime>(pEntity);
        Collections.sort(copyList, new OrderAT_KadouTime(orders));
        return copyList;
    }
}
