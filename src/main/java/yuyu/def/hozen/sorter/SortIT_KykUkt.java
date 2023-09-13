package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.meta.QIT_KykUkt;
import yuyu.def.hozen.comparator.OrderIT_KykUkt;

public class SortIT_KykUkt {

    public List<IT_KykUkt> OrderIT_KykUktByPkAsc(List<IT_KykUkt> pEntity) {
        List<SortCondition<IT_KykUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykUkt()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).uktsyurenno, SortOrder.ASC));
        List<IT_KykUkt> copyList = new ArrayList<IT_KykUkt>(pEntity);
        Collections.sort(copyList, new OrderIT_KykUkt(orders));
        return copyList;
    }

    public List<IT_KykUkt> OrderIT_KykUktByPkDesc(List<IT_KykUkt> pEntity) {
        List<SortCondition<IT_KykUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykUkt()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykUkt()).uktsyurenno, SortOrder.DESC));
        List<IT_KykUkt> copyList = new ArrayList<IT_KykUkt>(pEntity);
        Collections.sort(copyList, new OrderIT_KykUkt(orders));
        return copyList;
    }

}

