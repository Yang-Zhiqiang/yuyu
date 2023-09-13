package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.hozen.comparator.OrderIT_KykSonotaTkyk;

public class SortIT_KykSonotaTkyk {

    public List<IT_KykSonotaTkyk> OrderIT_KykSonotaTkykByPkAsc(List<IT_KykSonotaTkyk> pEntity) {
        List<SortCondition<IT_KykSonotaTkyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSonotaTkyk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSonotaTkyk()).syono, SortOrder.ASC));
        List<IT_KykSonotaTkyk> copyList = new ArrayList<IT_KykSonotaTkyk>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSonotaTkyk(orders));
        return copyList;
    }

    public List<IT_KykSonotaTkyk> OrderIT_KykSonotaTkykByPkDesc(List<IT_KykSonotaTkyk> pEntity) {
        List<SortCondition<IT_KykSonotaTkyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSonotaTkyk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSonotaTkyk()).syono, SortOrder.DESC));
        List<IT_KykSonotaTkyk> copyList = new ArrayList<IT_KykSonotaTkyk>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSonotaTkyk(orders));
        return copyList;
    }

}

