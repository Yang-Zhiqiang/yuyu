package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KktNkGnsritu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import yuyu.def.db.meta.QBM_KktNkGnsritu;

public class SortBM_KktNkGnsritu {

    public List<BM_KktNkGnsritu> OrderBM_KktNkGnsrituByPkAsc(List<BM_KktNkGnsritu> pEntity) {
        List<SortCondition<BM_KktNkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).shrkkn, SortOrder.ASC));
        List<BM_KktNkGnsritu> copyList = new ArrayList<BM_KktNkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_KktNkGnsritu(orders));
        return copyList;
    }

    public List<BM_KktNkGnsritu> OrderBM_KktNkGnsrituByPkDesc(List<BM_KktNkGnsritu> pEntity) {
        List<SortCondition<BM_KktNkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KktNkGnsritu()).shrkkn, SortOrder.DESC));
        List<BM_KktNkGnsritu> copyList = new ArrayList<BM_KktNkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_KktNkGnsritu(orders));
        return copyList;
    }
}
