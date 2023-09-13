package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykDairiten;
import yuyu.def.db.meta.QIT_BAK_KykDairiten;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykDairiten;

public class SortIT_BAK_KykDairiten {

    public List<IT_BAK_KykDairiten> OrderIT_BAK_KykDairitenByPkAsc(List<IT_BAK_KykDairiten> pEntity) {
        List<SortCondition<IT_BAK_KykDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).drtenrenno, SortOrder.ASC));
        List<IT_BAK_KykDairiten> copyList = new ArrayList<IT_BAK_KykDairiten>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykDairiten(orders));
        return copyList;
    }

    public List<IT_BAK_KykDairiten> OrderIT_BAK_KykDairitenByPkDesc(List<IT_BAK_KykDairiten> pEntity) {
        List<SortCondition<IT_BAK_KykDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykDairiten()).drtenrenno, SortOrder.DESC));
        List<IT_BAK_KykDairiten> copyList = new ArrayList<IT_BAK_KykDairiten>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykDairiten(orders));
        return copyList;
    }

}

