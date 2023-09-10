package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JW_HubiWk;
import yuyu.def.db.meta.QJW_HubiWk;
import yuyu.def.siharai.comparator.OrderJW_HubiWk;

public class SortJW_HubiWk {

    
    public List<JW_HubiWk> OrderJW_HubiWkByPkAsc(List<JW_HubiWk> pEntity) {
        List<SortCondition<JW_HubiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiWk()).kouteikanriid, SortOrder.ASC));
        List<JW_HubiWk> copyList = new ArrayList<JW_HubiWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiWk(orders));
        return copyList;
    }

    
    public List<JW_HubiWk> OrderJW_HubiWkByPkDesc(List<JW_HubiWk> pEntity) {
        List<SortCondition<JW_HubiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiWk()).kouteikanriid, SortOrder.DESC));
        List<JW_HubiWk> copyList = new ArrayList<JW_HubiWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiWk(orders));
        return copyList;
    }

}

