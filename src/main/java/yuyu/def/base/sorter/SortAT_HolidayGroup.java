package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_HolidayGroup;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.meta.QAT_HolidayGroup;

public class SortAT_HolidayGroup {

    public List<AT_HolidayGroup> OrderAT_HolidayGroupByPkAsc(List<AT_HolidayGroup> pEntity) {
        List<SortCondition<AT_HolidayGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HolidayGroup()).holidayGroupCd, SortOrder.ASC));
        List<AT_HolidayGroup> copyList = new ArrayList<AT_HolidayGroup>(pEntity);
        Collections.sort(copyList, new OrderAT_HolidayGroup(orders));
        return copyList;
    }

    public List<AT_HolidayGroup> OrderAT_HolidayGroupByPkDesc(List<AT_HolidayGroup> pEntity) {
        List<SortCondition<AT_HolidayGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HolidayGroup()).holidayGroupCd, SortOrder.DESC));
        List<AT_HolidayGroup> copyList = new ArrayList<AT_HolidayGroup>(pEntity);
        Collections.sort(copyList, new OrderAT_HolidayGroup(orders));
        return copyList;
    }
}
