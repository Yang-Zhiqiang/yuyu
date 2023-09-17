package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_SequenceValue;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.meta.QAT_SequenceValue;

public class SortAT_SequenceValue {

    public List<AT_SequenceValue> OrderAT_SequenceValueByPkAsc(List<AT_SequenceValue> pEntity) {
        List<SortCondition<AT_SequenceValue>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SequenceValue()).id, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_SequenceValue()).keys, SortOrder.ASC));
        List<AT_SequenceValue> copyList = new ArrayList<AT_SequenceValue>(pEntity);
        Collections.sort(copyList, new OrderAT_SequenceValue(orders));
        return copyList;
    }

    public List<AT_SequenceValue> OrderAT_SequenceValueByPkDesc(List<AT_SequenceValue> pEntity) {
        List<SortCondition<AT_SequenceValue>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SequenceValue()).id, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_SequenceValue()).keys, SortOrder.DESC));
        List<AT_SequenceValue> copyList = new ArrayList<AT_SequenceValue>(pEntity);
        Collections.sort(copyList, new OrderAT_SequenceValue(orders));
        return copyList;
    }
}
