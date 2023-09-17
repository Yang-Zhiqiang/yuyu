package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Ginkou;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.meta.QBM_Ginkou;

public class SortBM_Ginkou {

    public List<BM_Ginkou> OrderBM_GinkouByPkAsc(List<BM_Ginkou> pEntity) {
        List<SortCondition<BM_Ginkou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Ginkou()).bankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Ginkou()).sitencd, SortOrder.ASC));
        List<BM_Ginkou> copyList = new ArrayList<BM_Ginkou>(pEntity);
        Collections.sort(copyList, new OrderBM_Ginkou(orders));
        return copyList;
    }

    public List<BM_Ginkou> OrderBM_GinkouByPkDesc(List<BM_Ginkou> pEntity) {
        List<SortCondition<BM_Ginkou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Ginkou()).bankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Ginkou()).sitencd, SortOrder.DESC));
        List<BM_Ginkou> copyList = new ArrayList<BM_Ginkou>(pEntity);
        Collections.sort(copyList, new OrderBM_Ginkou(orders));
        return copyList;
    }

}

