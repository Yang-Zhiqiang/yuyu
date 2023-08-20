package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.meta.QSV_SnkiykGtjSirt;
import yuyu.def.suuri.comparator.OrderSV_SnkiykGtjSirt;

public class SortSV_SnkiykGtjSirt {

    
    public List<SV_SnkiykGtjSirt> OrderSV_SnkiykGtjSirtByPkAsc(List<SV_SnkiykGtjSirt> pEntity) {
        List<SortCondition<SV_SnkiykGtjSirt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SnkiykGtjSirt()).mosno, SortOrder.ASC));
        List<SV_SnkiykGtjSirt> copyList = new ArrayList<SV_SnkiykGtjSirt>(pEntity);
        Collections.sort(copyList, new OrderSV_SnkiykGtjSirt(orders));
        return copyList;
    }

    
    public List<SV_SnkiykGtjSirt> OrderSV_SnkiykGtjSirtByPkDesc(List<SV_SnkiykGtjSirt> pEntity) {
        List<SortCondition<SV_SnkiykGtjSirt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SnkiykGtjSirt()).mosno, SortOrder.DESC));
        List<SV_SnkiykGtjSirt> copyList = new ArrayList<SV_SnkiykGtjSirt>(pEntity);
        Collections.sort(copyList, new OrderSV_SnkiykGtjSirt(orders));
        return copyList;
    }
}
