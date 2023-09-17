package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_Batch;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.meta.QAM_Batch;

public class SortAM_Batch {

    public List<AM_Batch> OrderAM_BatchByPkAsc(List<AM_Batch> pEntity) {
        List<SortCondition<AM_Batch>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Batch()).kinouId, SortOrder.ASC));
        List<AM_Batch> copyList = new ArrayList<AM_Batch>(pEntity);
        Collections.sort(copyList, new OrderAM_Batch(orders));
        return copyList;
    }

    public List<AM_Batch> OrderAM_BatchByPkDesc(List<AM_Batch> pEntity) {
        List<SortCondition<AM_Batch>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Batch()).kinouId, SortOrder.DESC));
        List<AM_Batch> copyList = new ArrayList<AM_Batch>(pEntity);
        Collections.sort(copyList, new OrderAM_Batch(orders));
        return copyList;
    }
}
