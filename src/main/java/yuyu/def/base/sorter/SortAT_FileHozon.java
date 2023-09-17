package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileHozon;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.meta.QAT_FileHozon;

public class SortAT_FileHozon {

    public List<AT_FileHozon> OrderAT_FileHozonByPkAsc(List<AT_FileHozon> pEntity) {
        List<SortCondition<AT_FileHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileHozon()).uniqueId, SortOrder.ASC));
        List<AT_FileHozon> copyList = new ArrayList<AT_FileHozon>(pEntity);
        Collections.sort(copyList, new OrderAT_FileHozon(orders));
        return copyList;
    }

    public List<AT_FileHozon> OrderAT_FileHozonByPkDesc(List<AT_FileHozon> pEntity) {
        List<SortCondition<AT_FileHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileHozon()).uniqueId, SortOrder.DESC));
        List<AT_FileHozon> copyList = new ArrayList<AT_FileHozon>(pEntity);
        Collections.sort(copyList, new OrderAT_FileHozon(orders));
        return copyList;
    }
}
