package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_AlmNnknHyu;
import yuyu.def.db.meta.QSV_AlmNnknHyu;
import yuyu.def.suuri.comparator.OrderSV_AlmNnknHyu;

public class SortSV_AlmNnknHyu {

    
    public List<SV_AlmNnknHyu> OrderSV_AlmNnknHyuByPkAsc(List<SV_AlmNnknHyu> pEntity) {
        List<SortCondition<SV_AlmNnknHyu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_AlmNnknHyu()).renno8keta, SortOrder.ASC));
        List<SV_AlmNnknHyu> copyList = new ArrayList<SV_AlmNnknHyu>(pEntity);
        Collections.sort(copyList, new OrderSV_AlmNnknHyu(orders));
        return copyList;
    }

    
    public List<SV_AlmNnknHyu> OrderSV_AlmNnknHyuByPkDesc(List<SV_AlmNnknHyu> pEntity) {
        List<SortCondition<SV_AlmNnknHyu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_AlmNnknHyu()).renno8keta, SortOrder.DESC));
        List<SV_AlmNnknHyu> copyList = new ArrayList<SV_AlmNnknHyu>(pEntity);
        Collections.sort(copyList, new OrderSV_AlmNnknHyu(orders));
        return copyList;
    }
}
