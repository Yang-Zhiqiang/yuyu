package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Kouza;
import yuyu.def.db.meta.QIT_BAK_Kouza;
import yuyu.def.hozen.comparator.OrderIT_BAK_Kouza;

public class SortIT_BAK_Kouza {

    public List<IT_BAK_Kouza> OrderIT_BAK_KouzaByPkAsc(List<IT_BAK_Kouza> pEntity) {
        List<SortCondition<IT_BAK_Kouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_Kouza> copyList = new ArrayList<IT_BAK_Kouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Kouza(orders));
        return copyList;
    }

    public List<IT_BAK_Kouza> OrderIT_BAK_KouzaByPkDesc(List<IT_BAK_Kouza> pEntity) {
        List<SortCondition<IT_BAK_Kouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Kouza()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_Kouza> copyList = new ArrayList<IT_BAK_Kouza>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Kouza(orders));
        return copyList;
    }

}

