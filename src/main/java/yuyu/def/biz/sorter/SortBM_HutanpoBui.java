package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_HutanpoBui;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.meta.QBM_HutanpoBui;

public class SortBM_HutanpoBui {

    public List<BM_HutanpoBui> OrderBM_HutanpoBuiByPkAsc(List<BM_HutanpoBui> pEntity) {
        List<SortCondition<BM_HutanpoBui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HutanpoBui()).htnpbuicd, SortOrder.ASC));
        List<BM_HutanpoBui> copyList = new ArrayList<BM_HutanpoBui>(pEntity);
        Collections.sort(copyList, new OrderBM_HutanpoBui(orders));
        return copyList;
    }

    public List<BM_HutanpoBui> OrderBM_HutanpoBuiByPkDesc(List<BM_HutanpoBui> pEntity) {
        List<SortCondition<BM_HutanpoBui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_HutanpoBui()).htnpbuicd, SortOrder.DESC));
        List<BM_HutanpoBui> copyList = new ArrayList<BM_HutanpoBui>(pEntity);
        Collections.sort(copyList, new OrderBM_HutanpoBui(orders));
        return copyList;
    }

}

