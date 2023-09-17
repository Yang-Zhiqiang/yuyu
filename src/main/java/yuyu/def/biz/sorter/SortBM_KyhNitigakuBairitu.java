package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KyhNitigakuBairitu;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;
import yuyu.def.db.meta.QBM_KyhNitigakuBairitu;

public class SortBM_KyhNitigakuBairitu {

    public List<BM_KyhNitigakuBairitu> OrderBM_KyhNitigakuBairituByPkAsc(List<BM_KyhNitigakuBairitu> pEntity) {
        List<SortCondition<BM_KyhNitigakuBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).katakbn, SortOrder.ASC));
        List<BM_KyhNitigakuBairitu> copyList = new ArrayList<BM_KyhNitigakuBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_KyhNitigakuBairitu(orders));
        return copyList;
    }

    public List<BM_KyhNitigakuBairitu> OrderBM_KyhNitigakuBairituByPkDesc(List<BM_KyhNitigakuBairitu> pEntity) {
        List<SortCondition<BM_KyhNitigakuBairitu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_KyhNitigakuBairitu()).katakbn, SortOrder.DESC));
        List<BM_KyhNitigakuBairitu> copyList = new ArrayList<BM_KyhNitigakuBairitu>(pEntity);
        Collections.sort(copyList, new OrderBM_KyhNitigakuBairitu(orders));
        return copyList;
    }

}

