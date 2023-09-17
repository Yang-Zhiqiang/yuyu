package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_BatchJob;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.meta.QAT_BatchJob;

public class SortAT_BatchJob {

    public List<AT_BatchJob> OrderAT_BatchJobByPkAsc(List<AT_BatchJob> pEntity) {
        List<SortCondition<AT_BatchJob>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchJob()).batchJobId, SortOrder.ASC));
        List<AT_BatchJob> copyList = new ArrayList<AT_BatchJob>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchJob(orders));
        return copyList;
    }

    public List<AT_BatchJob> OrderAT_BatchJobByPkDesc(List<AT_BatchJob> pEntity) {
        List<SortCondition<AT_BatchJob>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchJob()).batchJobId, SortOrder.DESC));
        List<AT_BatchJob> copyList = new ArrayList<AT_BatchJob>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchJob(orders));
        return copyList;
    }
}
