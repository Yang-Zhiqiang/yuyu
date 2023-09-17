package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_AccessLog;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;

public class SortAT_AccessLog {

    public List<AT_AccessLog> OrderAT_AccessLogByPkAsc(List<AT_AccessLog> pEntity) {
        List<SortCondition<AT_AccessLog>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AccessLog()).logId, SortOrder.ASC));
        List<AT_AccessLog> copyList = new ArrayList<AT_AccessLog>(pEntity);
        Collections.sort(copyList, new OrderAT_AccessLog(orders));
        return copyList;
    }

    public List<AT_AccessLog> OrderAT_AccessLogByPkDesc(List<AT_AccessLog> pEntity) {
        List<SortCondition<AT_AccessLog>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AccessLog()).logId, SortOrder.DESC));
        List<AT_AccessLog> copyList = new ArrayList<AT_AccessLog>(pEntity);
        Collections.sort(copyList, new OrderAT_AccessLog(orders));
        return copyList;
    }
}
