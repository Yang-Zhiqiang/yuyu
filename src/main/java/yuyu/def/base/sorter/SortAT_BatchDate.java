package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_BatchDate;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.meta.QAT_BatchDate;

public class SortAT_BatchDate {

    public List<AT_BatchDate> OrderAT_BatchDateByPkAsc(List<AT_BatchDate> pEntity) {
        List<SortCondition<AT_BatchDate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchDate()).batchExecDate, SortOrder.ASC));
        List<AT_BatchDate> copyList = new ArrayList<AT_BatchDate>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchDate(orders));
        return copyList;
    }

    public List<AT_BatchDate> OrderAT_BatchDateByPkDesc(List<AT_BatchDate> pEntity) {
        List<SortCondition<AT_BatchDate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchDate()).batchExecDate, SortOrder.DESC));
        List<AT_BatchDate> copyList = new ArrayList<AT_BatchDate>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchDate(orders));
        return copyList;
    }
}
