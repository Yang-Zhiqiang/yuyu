package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_BAK_KykSonotaTkyk;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykSonotaTkyk;

public class SortIT_BAK_KykSonotaTkyk {

    public List<IT_BAK_KykSonotaTkyk> OrderIT_BAK_KykSonotaTkykByPkAsc(List<IT_BAK_KykSonotaTkyk> pEntity) {
        List<SortCondition<IT_BAK_KykSonotaTkyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KykSonotaTkyk> copyList = new ArrayList<IT_BAK_KykSonotaTkyk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSonotaTkyk(orders));
        return copyList;
    }

    public List<IT_BAK_KykSonotaTkyk> OrderIT_BAK_KykSonotaTkykByPkDesc(List<IT_BAK_KykSonotaTkyk> pEntity) {
        List<SortCondition<IT_BAK_KykSonotaTkyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSonotaTkyk()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KykSonotaTkyk> copyList = new ArrayList<IT_BAK_KykSonotaTkyk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSonotaTkyk(orders));
        return copyList;
    }

}

