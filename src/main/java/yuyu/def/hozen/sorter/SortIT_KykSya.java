package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.hozen.comparator.OrderIT_KykSya;

public class SortIT_KykSya {

    public List<IT_KykSya> OrderIT_KykSyaByPkAsc(List<IT_KykSya> pEntity) {
        List<SortCondition<IT_KykSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSya()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSya()).syono, SortOrder.ASC));
        List<IT_KykSya> copyList = new ArrayList<IT_KykSya>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSya(orders));
        return copyList;
    }

    public List<IT_KykSya> OrderIT_KykSyaByPkDesc(List<IT_KykSya> pEntity) {
        List<SortCondition<IT_KykSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSya()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSya()).syono, SortOrder.DESC));
        List<IT_KykSya> copyList = new ArrayList<IT_KykSya>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSya(orders));
        return copyList;
    }

}

