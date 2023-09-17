package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_BatchLog;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.meta.QAT_BatchLog;

public class SortAT_BatchLog {

    public List<AT_BatchLog> OrderAT_BatchLogByPkAsc(List<AT_BatchLog> pEntity) {
        List<SortCondition<AT_BatchLog>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLog()).batchJobId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_BatchLog()).batchLogEdaNo, SortOrder.ASC));
        List<AT_BatchLog> copyList = new ArrayList<AT_BatchLog>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLog(orders));
        return copyList;
    }

    public List<AT_BatchLog> OrderAT_BatchLogByPkDesc(List<AT_BatchLog> pEntity) {
        List<SortCondition<AT_BatchLog>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLog()).batchJobId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_BatchLog()).batchLogEdaNo, SortOrder.DESC));
        List<AT_BatchLog> copyList = new ArrayList<AT_BatchLog>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLog(orders));
        return copyList;
    }
}
