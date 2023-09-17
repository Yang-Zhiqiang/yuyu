package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.meta.QBM_KktNk1stNkBigkGnsritu;

public class SortBM_KktNk1stNkBigkGnsritu {

    public List<BM_KktNk1stNkBigkGnsritu> OrderBM_KktNk1stNkBigkGnsrituByPkAsc(List<BM_KktNk1stNkBigkGnsritu> pEntity) {
        List<SortCondition<BM_KktNk1stNkBigkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).shrkkn, SortOrder.ASC));
        List<BM_KktNk1stNkBigkGnsritu> copyList = new ArrayList<BM_KktNk1stNkBigkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_KktNk1stNkBigkGnsritu(orders));
        return copyList;
    }

    public List<BM_KktNk1stNkBigkGnsritu> OrderBM_KktNk1stNkBigkGnsrituByPkDesc(List<BM_KktNk1stNkBigkGnsritu> pEntity) {
        List<SortCondition<BM_KktNk1stNkBigkGnsritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KktNk1stNkBigkGnsritu()).shrkkn, SortOrder.DESC));
        List<BM_KktNk1stNkBigkGnsritu> copyList = new ArrayList<BM_KktNk1stNkBigkGnsritu>(pEntity);
        Collections.sort(copyList, new OrderBM_KktNk1stNkBigkGnsritu(orders));
        return copyList;
    }
}
