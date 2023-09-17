package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Tuuka;
import yuyu.def.db.entity.BM_Tuuka;
import yuyu.def.db.meta.QBM_Tuuka;

public class SortBM_Tuuka {

    public List<BM_Tuuka> OrderBM_TuukaByPkAsc(List<BM_Tuuka> pEntity) {
        List<SortCondition<BM_Tuuka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Tuuka()).tuukasyu, SortOrder.ASC));
        List<BM_Tuuka> copyList = new ArrayList<BM_Tuuka>(pEntity);
        Collections.sort(copyList, new OrderBM_Tuuka(orders));
        return copyList;
    }

    public List<BM_Tuuka> OrderBM_TuukaByPkDesc(List<BM_Tuuka> pEntity) {
        List<SortCondition<BM_Tuuka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Tuuka()).tuukasyu, SortOrder.DESC));
        List<BM_Tuuka> copyList = new ArrayList<BM_Tuuka>(pEntity);
        Collections.sort(copyList, new OrderBM_Tuuka(orders));
        return copyList;
    }

}

