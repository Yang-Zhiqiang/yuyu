package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_KinouKengen;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.meta.QAT_KinouKengen;

public class SortAT_KinouKengen {

    public List<AT_KinouKengen> OrderAT_KinouKengenByPkAsc(List<AT_KinouKengen> pEntity) {
        List<SortCondition<AT_KinouKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KinouKengen()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KinouKengen()).kinouModeId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KinouKengen()).roleCd, SortOrder.ASC));
        List<AT_KinouKengen> copyList = new ArrayList<AT_KinouKengen>(pEntity);
        Collections.sort(copyList, new OrderAT_KinouKengen(orders));
        return copyList;
    }

    public List<AT_KinouKengen> OrderAT_KinouKengenByPkDesc(List<AT_KinouKengen> pEntity) {
        List<SortCondition<AT_KinouKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KinouKengen()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KinouKengen()).kinouModeId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KinouKengen()).roleCd, SortOrder.DESC));
        List<AT_KinouKengen> copyList = new ArrayList<AT_KinouKengen>(pEntity);
        Collections.sort(copyList, new OrderAT_KinouKengen(orders));
        return copyList;
    }
}
