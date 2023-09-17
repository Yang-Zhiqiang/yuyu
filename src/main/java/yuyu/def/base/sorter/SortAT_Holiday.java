package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_Holiday;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.meta.QAT_Holiday;

public class SortAT_Holiday {

    public List<AT_Holiday> OrderAT_HolidayByPkAsc(List<AT_Holiday> pEntity) {
        List<SortCondition<AT_Holiday>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_Holiday()).holidayGroupCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_Holiday()).holidayCd, SortOrder.ASC));
        List<AT_Holiday> copyList = new ArrayList<AT_Holiday>(pEntity);
        Collections.sort(copyList, new OrderAT_Holiday(orders));
        return copyList;
    }

    public List<AT_Holiday> OrderAT_HolidayByPkDesc(List<AT_Holiday> pEntity) {
        List<SortCondition<AT_Holiday>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_Holiday()).holidayGroupCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_Holiday()).holidayCd, SortOrder.DESC));
        List<AT_Holiday> copyList = new ArrayList<AT_Holiday>(pEntity);
        Collections.sort(copyList, new OrderAT_Holiday(orders));
        return copyList;
    }
}
