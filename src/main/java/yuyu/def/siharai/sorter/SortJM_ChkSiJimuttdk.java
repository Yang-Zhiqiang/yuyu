package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.meta.QJM_ChkSiJimuttdk;
import yuyu.def.siharai.comparator.OrderJM_ChkSiJimuttdk;

public class SortJM_ChkSiJimuttdk {

    
    public List<JM_ChkSiJimuttdk> OrderJM_ChkSiJimuttdkByPkAsc(List<JM_ChkSiJimuttdk> pEntity) {
        List<SortCondition<JM_ChkSiJimuttdk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_ChkSiJimuttdk()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_ChkSiJimuttdk()).syorijimuttdkcd, SortOrder.ASC));
        List<JM_ChkSiJimuttdk> copyList = new ArrayList<JM_ChkSiJimuttdk>(pEntity);
        Collections.sort(copyList, new OrderJM_ChkSiJimuttdk(orders));
        return copyList;
    }

    
    public List<JM_ChkSiJimuttdk> OrderJM_ChkSiJimuttdkByPkDesc(List<JM_ChkSiJimuttdk> pEntity) {
        List<SortCondition<JM_ChkSiJimuttdk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_ChkSiJimuttdk()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_ChkSiJimuttdk()).syorijimuttdkcd, SortOrder.DESC));
        List<JM_ChkSiJimuttdk> copyList = new ArrayList<JM_ChkSiJimuttdk>(pEntity);
        Collections.sort(copyList, new OrderJM_ChkSiJimuttdk(orders));
        return copyList;
    }
}
