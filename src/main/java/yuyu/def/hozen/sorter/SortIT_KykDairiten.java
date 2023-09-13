package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.hozen.comparator.OrderIT_KykDairiten;

public class SortIT_KykDairiten {

    public List<IT_KykDairiten> OrderIT_KykDairitenByPkAsc(List<IT_KykDairiten> pEntity) {
        List<SortCondition<IT_KykDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykDairiten()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykDairiten()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykDairiten()).drtenrenno, SortOrder.ASC));
        List<IT_KykDairiten> copyList = new ArrayList<IT_KykDairiten>(pEntity);
        Collections.sort(copyList, new OrderIT_KykDairiten(orders));
        return copyList;
    }

    public List<IT_KykDairiten> OrderIT_KykDairitenByPkDesc(List<IT_KykDairiten> pEntity) {
        List<SortCondition<IT_KykDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykDairiten()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykDairiten()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykDairiten()).drtenrenno, SortOrder.DESC));
        List<IT_KykDairiten> copyList = new ArrayList<IT_KykDairiten>(pEntity);
        Collections.sort(copyList, new OrderIT_KykDairiten(orders));
        return copyList;
    }

}

