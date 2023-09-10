package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JW_HubiDetailWk;
import yuyu.def.db.meta.QJW_HubiDetailWk;
import yuyu.def.siharai.comparator.OrderJW_HubiDetailWk;

public class SortJW_HubiDetailWk {

    
    public List<JW_HubiDetailWk> OrderJW_HubiDetailWkByPkAsc(List<JW_HubiDetailWk> pEntity) {
        List<SortCondition<JW_HubiDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiDetailWk()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJW_HubiDetailWk()).renno3keta, SortOrder.ASC));
        List<JW_HubiDetailWk> copyList = new ArrayList<JW_HubiDetailWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiDetailWk(orders));
        return copyList;
    }

    
    public List<JW_HubiDetailWk> OrderJW_HubiDetailWkByPkDesc(List<JW_HubiDetailWk> pEntity) {
        List<SortCondition<JW_HubiDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiDetailWk()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJW_HubiDetailWk()).renno3keta, SortOrder.DESC));
        List<JW_HubiDetailWk> copyList = new ArrayList<JW_HubiDetailWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiDetailWk(orders));
        return copyList;
    }

}

