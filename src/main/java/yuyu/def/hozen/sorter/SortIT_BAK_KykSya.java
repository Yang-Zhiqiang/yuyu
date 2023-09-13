package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykSya;
import yuyu.def.db.meta.QIT_BAK_KykSya;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykSya;

public class SortIT_BAK_KykSya {

    public List<IT_BAK_KykSya> OrderIT_BAK_KykSyaByPkAsc(List<IT_BAK_KykSya> pEntity) {
        List<SortCondition<IT_BAK_KykSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KykSya> copyList = new ArrayList<IT_BAK_KykSya>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSya(orders));
        return copyList;
    }

    public List<IT_BAK_KykSya> OrderIT_BAK_KykSyaByPkDesc(List<IT_BAK_KykSya> pEntity) {
        List<SortCondition<IT_BAK_KykSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSya()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KykSya> copyList = new ArrayList<IT_BAK_KykSya>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSya(orders));
        return copyList;
    }

}

