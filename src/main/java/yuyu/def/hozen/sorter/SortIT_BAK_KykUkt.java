package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykUkt;
import yuyu.def.db.meta.QIT_BAK_KykUkt;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykUkt;

public class SortIT_BAK_KykUkt {

    public List<IT_BAK_KykUkt> OrderIT_BAK_KykUktByPkAsc(List<IT_BAK_KykUkt> pEntity) {
        List<SortCondition<IT_BAK_KykUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).uktsyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).uktsyurenno, SortOrder.ASC));
        List<IT_BAK_KykUkt> copyList = new ArrayList<IT_BAK_KykUkt>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykUkt(orders));
        return copyList;
    }

    public List<IT_BAK_KykUkt> OrderIT_BAK_KykUktByPkDesc(List<IT_BAK_KykUkt> pEntity) {
        List<SortCondition<IT_BAK_KykUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).uktsyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykUkt()).uktsyurenno, SortOrder.DESC));
        List<IT_BAK_KykUkt> copyList = new ArrayList<IT_BAK_KykUkt>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykUkt(orders));
        return copyList;
    }

}

