package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Tokusin;
import yuyu.def.db.meta.QIT_BAK_Tokusin;
import yuyu.def.hozen.comparator.OrderIT_BAK_Tokusin;

public class SortIT_BAK_Tokusin {

    public List<IT_BAK_Tokusin> OrderIT_BAK_TokusinByPkAsc(List<IT_BAK_Tokusin> pEntity) {
        List<SortCondition<IT_BAK_Tokusin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_Tokusin> copyList = new ArrayList<IT_BAK_Tokusin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Tokusin(orders));
        return copyList;
    }

    public List<IT_BAK_Tokusin> OrderIT_BAK_TokusinByPkDesc(List<IT_BAK_Tokusin> pEntity) {
        List<SortCondition<IT_BAK_Tokusin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Tokusin()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_Tokusin> copyList = new ArrayList<IT_BAK_Tokusin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Tokusin(orders));
        return copyList;
    }

}

