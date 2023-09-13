package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.meta.QIT_DattaiUktk;
import yuyu.def.hozen.comparator.OrderIT_DattaiUktk;

public class SortIT_DattaiUktk {

    public List<IT_DattaiUktk> OrderIT_DattaiUktkByPkAsc(List<IT_DattaiUktk> pEntity) {
        List<SortCondition<IT_DattaiUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DattaiUktk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DattaiUktk()).syono, SortOrder.ASC));
        List<IT_DattaiUktk> copyList = new ArrayList<IT_DattaiUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_DattaiUktk(orders));
        return copyList;
    }

    public List<IT_DattaiUktk> OrderIT_DattaiUktkByPkDesc(List<IT_DattaiUktk> pEntity) {
        List<SortCondition<IT_DattaiUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DattaiUktk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DattaiUktk()).syono, SortOrder.DESC));
        List<IT_DattaiUktk> copyList = new ArrayList<IT_DattaiUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_DattaiUktk(orders));
        return copyList;
    }

}

