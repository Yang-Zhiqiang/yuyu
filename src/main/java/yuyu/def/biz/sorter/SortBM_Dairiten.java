package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Dairiten;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.meta.QBM_Dairiten;

public class SortBM_Dairiten {

    public List<BM_Dairiten> OrderBM_DairitenByPkAsc(List<BM_Dairiten> pEntity) {
        List<SortCondition<BM_Dairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Dairiten()).drtencd, SortOrder.ASC));
        List<BM_Dairiten> copyList = new ArrayList<BM_Dairiten>(pEntity);
        Collections.sort(copyList, new OrderBM_Dairiten(orders));
        return copyList;
    }

    public List<BM_Dairiten> OrderBM_DairitenByPkDesc(List<BM_Dairiten> pEntity) {
        List<SortCondition<BM_Dairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Dairiten()).drtencd, SortOrder.DESC));
        List<BM_Dairiten> copyList = new ArrayList<BM_Dairiten>(pEntity);
        Collections.sort(copyList, new OrderBM_Dairiten(orders));
        return copyList;
    }

}

