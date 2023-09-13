package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.meta.QIT_Kouza;
import yuyu.def.hozen.comparator.OrderIT_Kouza;

public class SortIT_Kouza {

    public List<IT_Kouza> OrderIT_KouzaByPkAsc(List<IT_Kouza> pEntity) {
        List<SortCondition<IT_Kouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Kouza()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Kouza()).syono, SortOrder.ASC));
        List<IT_Kouza> copyList = new ArrayList<IT_Kouza>(pEntity);
        Collections.sort(copyList, new OrderIT_Kouza(orders));
        return copyList;
    }

    public List<IT_Kouza> OrderIT_KouzaByPkDesc(List<IT_Kouza> pEntity) {
        List<SortCondition<IT_Kouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Kouza()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Kouza()).syono, SortOrder.DESC));
        List<IT_Kouza> copyList = new ArrayList<IT_Kouza>(pEntity);
        Collections.sort(copyList, new OrderIT_Kouza(orders));
        return copyList;
    }

}

