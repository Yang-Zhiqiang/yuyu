package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.meta.QIT_BAK_KykKihon;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykKihon;

public class SortIT_BAK_KykKihon {

    public List<IT_BAK_KykKihon> OrderIT_BAK_KykKihonByPkAsc(List<IT_BAK_KykKihon> pEntity) {
        List<SortCondition<IT_BAK_KykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KykKihon> copyList = new ArrayList<IT_BAK_KykKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykKihon(orders));
        return copyList;
    }

    public List<IT_BAK_KykKihon> OrderIT_BAK_KykKihonByPkDesc(List<IT_BAK_KykKihon> pEntity) {
        List<SortCondition<IT_BAK_KykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykKihon()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KykKihon> copyList = new ArrayList<IT_BAK_KykKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykKihon(orders));
        return copyList;
    }

}

