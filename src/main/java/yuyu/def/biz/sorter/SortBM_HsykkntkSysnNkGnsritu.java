package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.QBM_HsykkntkSysnNkGnsritu;

public class SortBM_HsykkntkSysnNkGnsritu {

    public List<BM_HsykkntkSysnNkGnsritu> OrderBM_HsykkntkSysnNkGnsrituByPkAsc(List<BM_HsykkntkSysnNkGnsritu> pEntity) {
        List<SortCondition<BM_HsykkntkSysnNkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).seibetu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).nkshrstartnen, SortOrder.ASC));
        List<BM_HsykkntkSysnNkGnsritu> copyList = new ArrayList<BM_HsykkntkSysnNkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_HsykkntkSysnNkGnsritu(orders));
        return copyList;
    }

    public List<BM_HsykkntkSysnNkGnsritu> OrderBM_HsykkntkSysnNkGnsrituByPkDesc(List<BM_HsykkntkSysnNkGnsritu> pEntity) {
        List<SortCondition<BM_HsykkntkSysnNkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).seibetu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_HsykkntkSysnNkGnsritu()).nkshrstartnen, SortOrder.DESC));
        List<BM_HsykkntkSysnNkGnsritu> copyList = new ArrayList<BM_HsykkntkSysnNkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_HsykkntkSysnNkGnsritu(orders));
        return copyList;
    }
}
