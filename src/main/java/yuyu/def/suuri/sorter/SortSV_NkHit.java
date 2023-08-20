package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_NkHit;
import yuyu.def.db.meta.QSV_NkHit;
import yuyu.def.suuri.comparator.OrderSV_NkHit;

public class SortSV_NkHit {

    
    public List<SV_NkHit> OrderSV_NkHitByPkAsc(List<SV_NkHit> pEntity) {
        List<SortCondition<SV_NkHit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_NkHit()).renno8keta, SortOrder.ASC));
        List<SV_NkHit> copyList = new ArrayList<SV_NkHit>(pEntity);
        Collections.sort(copyList, new OrderSV_NkHit(orders));
        return copyList;
    }

    
    public List<SV_NkHit> OrderSV_NkHitByPkDesc(List<SV_NkHit> pEntity) {
        List<SortCondition<SV_NkHit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_NkHit()).renno8keta, SortOrder.DESC));
        List<SV_NkHit> copyList = new ArrayList<SV_NkHit>(pEntity);
        Collections.sort(copyList, new OrderSV_NkHit(orders));
        return copyList;
    }
}
