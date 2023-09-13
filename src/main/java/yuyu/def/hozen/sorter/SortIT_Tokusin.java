package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.meta.QIT_Tokusin;
import yuyu.def.hozen.comparator.OrderIT_Tokusin;

public class SortIT_Tokusin {

    public List<IT_Tokusin> OrderIT_TokusinByPkAsc(List<IT_Tokusin> pEntity) {
        List<SortCondition<IT_Tokusin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Tokusin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Tokusin()).syono, SortOrder.ASC));
        List<IT_Tokusin> copyList = new ArrayList<IT_Tokusin>(pEntity);
        Collections.sort(copyList, new OrderIT_Tokusin(orders));
        return copyList;
    }

    public List<IT_Tokusin> OrderIT_TokusinByPkDesc(List<IT_Tokusin> pEntity) {
        List<SortCondition<IT_Tokusin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Tokusin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Tokusin()).syono, SortOrder.DESC));
        List<IT_Tokusin> copyList = new ArrayList<IT_Tokusin>(pEntity);
        Collections.sort(copyList, new OrderIT_Tokusin(orders));
        return copyList;
    }

}

