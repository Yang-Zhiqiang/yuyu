package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_DattaiUktk;
import yuyu.def.db.meta.QIT_BAK_DattaiUktk;
import yuyu.def.hozen.comparator.OrderIT_BAK_DattaiUktk;

public class SortIT_BAK_DattaiUktk {

    public List<IT_BAK_DattaiUktk> OrderIT_BAK_DattaiUktkByPkAsc(List<IT_BAK_DattaiUktk> pEntity) {
        List<SortCondition<IT_BAK_DattaiUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_DattaiUktk> copyList = new ArrayList<IT_BAK_DattaiUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_DattaiUktk(orders));
        return copyList;
    }

    public List<IT_BAK_DattaiUktk> OrderIT_BAK_DattaiUktkByPkDesc(List<IT_BAK_DattaiUktk> pEntity) {
        List<SortCondition<IT_BAK_DattaiUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_DattaiUktk()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_DattaiUktk> copyList = new ArrayList<IT_BAK_DattaiUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_DattaiUktk(orders));
        return copyList;
    }

}

