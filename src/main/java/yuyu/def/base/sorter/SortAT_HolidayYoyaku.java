package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_HolidayYoyaku;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.meta.QAT_HolidayYoyaku;

public class SortAT_HolidayYoyaku {

    public List<AT_HolidayYoyaku> OrderAT_HolidayYoyakuByPkAsc(List<AT_HolidayYoyaku> pEntity) {
        List<SortCondition<AT_HolidayYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HolidayYoyaku()).holidayGroupCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_HolidayYoyaku()).holidayCd, SortOrder.ASC));
        List<AT_HolidayYoyaku> copyList = new ArrayList<AT_HolidayYoyaku>(pEntity);
        Collections.sort(copyList, new OrderAT_HolidayYoyaku(orders));
        return copyList;
    }

    public List<AT_HolidayYoyaku> OrderAT_HolidayYoyakuByPkDesc(List<AT_HolidayYoyaku> pEntity) {
        List<SortCondition<AT_HolidayYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_HolidayYoyaku()).holidayGroupCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_HolidayYoyaku()).holidayCd, SortOrder.DESC));
        List<AT_HolidayYoyaku> copyList = new ArrayList<AT_HolidayYoyaku>(pEntity);
        Collections.sort(copyList, new OrderAT_HolidayYoyaku(orders));
        return copyList;
    }
}
