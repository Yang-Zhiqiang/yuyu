package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.meta.QSV_SnkiykSyunyup;
import yuyu.def.suuri.comparator.OrderSV_SnkiykSyunyup;

public class SortSV_SnkiykSyunyup {

    
    public List<SV_SnkiykSyunyup> OrderSV_SnkiykSyunyupByPkAsc(List<SV_SnkiykSyunyup> pEntity) {
        List<SortCondition<SV_SnkiykSyunyup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SnkiykSyunyup()).mosno, SortOrder.ASC));
        List<SV_SnkiykSyunyup> copyList = new ArrayList<SV_SnkiykSyunyup>(pEntity);
        Collections.sort(copyList, new OrderSV_SnkiykSyunyup(orders));
        return copyList;
    }

    
    public List<SV_SnkiykSyunyup> OrderSV_SnkiykSyunyupByPkDesc(List<SV_SnkiykSyunyup> pEntity) {
        List<SortCondition<SV_SnkiykSyunyup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_SnkiykSyunyup()).mosno, SortOrder.DESC));
        List<SV_SnkiykSyunyup> copyList = new ArrayList<SV_SnkiykSyunyup>(pEntity);
        Collections.sort(copyList, new OrderSV_SnkiykSyunyup(orders));
        return copyList;
    }
}
