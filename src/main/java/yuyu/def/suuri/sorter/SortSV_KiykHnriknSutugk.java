package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.meta.QSV_KiykHnriknSutugk;
import yuyu.def.suuri.comparator.OrderSV_KiykHnriknSutugk;

public class SortSV_KiykHnriknSutugk {

    
    public List<SV_KiykHnriknSutugk> OrderSV_KiykHnriknSutugkByPkAsc(List<SV_KiykHnriknSutugk> pEntity) {
        List<SortCondition<SV_KiykHnriknSutugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_KiykHnriknSutugk()).syono, SortOrder.ASC));
        List<SV_KiykHnriknSutugk> copyList = new ArrayList<SV_KiykHnriknSutugk>(pEntity);
        Collections.sort(copyList, new OrderSV_KiykHnriknSutugk(orders));
        return copyList;
    }

    
    public List<SV_KiykHnriknSutugk> OrderSV_KiykHnriknSutugkByPkDesc(List<SV_KiykHnriknSutugk> pEntity) {
        List<SortCondition<SV_KiykHnriknSutugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_KiykHnriknSutugk()).syono, SortOrder.DESC));
        List<SV_KiykHnriknSutugk> copyList = new ArrayList<SV_KiykHnriknSutugk>(pEntity);
        Collections.sort(copyList, new OrderSV_KiykHnriknSutugk(orders));
        return copyList;
    }
}
