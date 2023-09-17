package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_TokuteibiKadouTime;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.meta.QAT_TokuteibiKadouTime;

public class SortAT_TokuteibiKadouTime {

    public List<AT_TokuteibiKadouTime> OrderAT_TokuteibiKadouTimeByPkAsc(List<AT_TokuteibiKadouTime> pEntity) {
        List<SortCondition<AT_TokuteibiKadouTime>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TokuteibiKadouTime()).kadouTimeGroupCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_TokuteibiKadouTime()).kadouTimeSiteiYmd, SortOrder.ASC));
        List<AT_TokuteibiKadouTime> copyList = new ArrayList<AT_TokuteibiKadouTime>(pEntity);
        Collections.sort(copyList, new OrderAT_TokuteibiKadouTime(orders));
        return copyList;
    }

    public List<AT_TokuteibiKadouTime> OrderAT_TokuteibiKadouTimeByPkDesc(List<AT_TokuteibiKadouTime> pEntity) {
        List<SortCondition<AT_TokuteibiKadouTime>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_TokuteibiKadouTime()).kadouTimeGroupCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_TokuteibiKadouTime()).kadouTimeSiteiYmd, SortOrder.DESC));
        List<AT_TokuteibiKadouTime> copyList = new ArrayList<AT_TokuteibiKadouTime>(pEntity);
        Collections.sort(copyList, new OrderAT_TokuteibiKadouTime(orders));
        return copyList;
    }
}
