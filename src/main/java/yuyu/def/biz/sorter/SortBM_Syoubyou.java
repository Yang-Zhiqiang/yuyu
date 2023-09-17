package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Syoubyou;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.meta.QBM_Syoubyou;

public class SortBM_Syoubyou {

    public List<BM_Syoubyou> OrderBM_SyoubyouByPkAsc(List<BM_Syoubyou> pEntity) {
        List<SortCondition<BM_Syoubyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syoubyou()).syoubyoucd, SortOrder.ASC));
        List<BM_Syoubyou> copyList = new ArrayList<BM_Syoubyou>(pEntity);
        Collections.sort(copyList, new OrderBM_Syoubyou(orders));
        return copyList;
    }

    public List<BM_Syoubyou> OrderBM_SyoubyouByPkDesc(List<BM_Syoubyou> pEntity) {
        List<SortCondition<BM_Syoubyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Syoubyou()).syoubyoucd, SortOrder.DESC));
        List<BM_Syoubyou> copyList = new ArrayList<BM_Syoubyou>(pEntity);
        Collections.sort(copyList, new OrderBM_Syoubyou(orders));
        return copyList;
    }

}

