package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.hozen.comparator.OrderIT_KykKihon;

public class SortIT_KykKihon {

    public List<IT_KykKihon> OrderIT_KykKihonByPkAsc(List<IT_KykKihon> pEntity) {
        List<SortCondition<IT_KykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykKihon()).syono, SortOrder.ASC));
        List<IT_KykKihon> copyList = new ArrayList<IT_KykKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_KykKihon(orders));
        return copyList;
    }

    public List<IT_KykKihon> OrderIT_KykKihonByPkDesc(List<IT_KykKihon> pEntity) {
        List<SortCondition<IT_KykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykKihon()).syono, SortOrder.DESC));
        List<IT_KykKihon> copyList = new ArrayList<IT_KykKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_KykKihon(orders));
        return copyList;
    }

}

