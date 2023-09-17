package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RecoveryFilter;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.meta.QBM_RecoveryFilter;

public class SortBM_RecoveryFilter {

    public List<BM_RecoveryFilter> OrderBM_RecoveryFilterByPkAsc(List<BM_RecoveryFilter> pEntity) {
        List<SortCondition<BM_RecoveryFilter>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RecoveryFilter()).recoveryfilterid, SortOrder.ASC));
        List<BM_RecoveryFilter> copyList = new ArrayList<BM_RecoveryFilter>(pEntity);
        Collections.sort(copyList, new OrderBM_RecoveryFilter(orders));
        return copyList;
    }

    public List<BM_RecoveryFilter> OrderBM_RecoveryFilterByPkDesc(List<BM_RecoveryFilter> pEntity) {
        List<SortCondition<BM_RecoveryFilter>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RecoveryFilter()).recoveryfilterid, SortOrder.DESC));
        List<BM_RecoveryFilter> copyList = new ArrayList<BM_RecoveryFilter>(pEntity);
        Collections.sort(copyList, new OrderBM_RecoveryFilter(orders));
        return copyList;
    }
}
