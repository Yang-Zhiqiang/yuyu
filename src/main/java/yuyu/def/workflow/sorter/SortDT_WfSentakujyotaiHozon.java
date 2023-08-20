package yuyu.def.workflow.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.db.meta.QDT_WfSentakujyotaiHozon;
import yuyu.def.workflow.comparator.OrderDT_WfSentakujyotaiHozon;

public class SortDT_WfSentakujyotaiHozon {

    public List<DT_WfSentakujyotaiHozon> OrderDT_WfSentakujyotaiHozonByPkAsc(List<DT_WfSentakujyotaiHozon> pEntity) {
        List<SortCondition<DT_WfSentakujyotaiHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_WfSentakujyotaiHozon()).userId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QDT_WfSentakujyotaiHozon()).subSystemId, SortOrder.ASC));
        List<DT_WfSentakujyotaiHozon> copyList = new ArrayList<DT_WfSentakujyotaiHozon>(pEntity);
        Collections.sort(copyList, new OrderDT_WfSentakujyotaiHozon(orders));
        return copyList;
    }

    public List<DT_WfSentakujyotaiHozon> OrderDT_WfSentakujyotaiHozonByPkDesc(List<DT_WfSentakujyotaiHozon> pEntity) {
        List<SortCondition<DT_WfSentakujyotaiHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QDT_WfSentakujyotaiHozon()).userId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QDT_WfSentakujyotaiHozon()).subSystemId, SortOrder.DESC));
        List<DT_WfSentakujyotaiHozon> copyList = new ArrayList<DT_WfSentakujyotaiHozon>(pEntity);
        Collections.sort(copyList, new OrderDT_WfSentakujyotaiHozon(orders));
        return copyList;
    }

}

