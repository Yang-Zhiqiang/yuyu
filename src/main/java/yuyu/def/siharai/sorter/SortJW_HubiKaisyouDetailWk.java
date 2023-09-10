package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.meta.QJW_HubiKaisyouDetailWk;
import yuyu.def.siharai.comparator.OrderJW_HubiKaisyouDetailWk;

public class SortJW_HubiKaisyouDetailWk {

    
    public List<JW_HubiKaisyouDetailWk> OrderJW_HubiKaisyouDetailWkByPkAsc(List<JW_HubiKaisyouDetailWk> pEntity) {
        List<SortCondition<JW_HubiKaisyouDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiKaisyouDetailWk()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJW_HubiKaisyouDetailWk()).renno3keta, SortOrder.ASC));
        List<JW_HubiKaisyouDetailWk> copyList = new ArrayList<JW_HubiKaisyouDetailWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiKaisyouDetailWk(orders));
        return copyList;
    }

    
    public List<JW_HubiKaisyouDetailWk> OrderJW_HubiKaisyouDetailWkByPkDesc(List<JW_HubiKaisyouDetailWk> pEntity) {
        List<SortCondition<JW_HubiKaisyouDetailWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJW_HubiKaisyouDetailWk()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJW_HubiKaisyouDetailWk()).renno3keta, SortOrder.DESC));
        List<JW_HubiKaisyouDetailWk> copyList = new ArrayList<JW_HubiKaisyouDetailWk>(pEntity);
        Collections.sort(copyList, new OrderJW_HubiKaisyouDetailWk(orders));
        return copyList;
    }

}

