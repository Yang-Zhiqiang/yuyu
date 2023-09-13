package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.meta.QIT_KyuukzAnnaimati;
import yuyu.def.hozen.comparator.OrderIT_KyuukzAnnaimati;

public class SortIT_KyuukzAnnaimati {

    public List<IT_KyuukzAnnaimati> OrderIT_KyuukzAnnaimatiByPkAsc(List<IT_KyuukzAnnaimati> pEntity) {
        List<SortCondition<IT_KyuukzAnnaimati>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KyuukzAnnaimati()).kouteikanriid, SortOrder.ASC));
        List<IT_KyuukzAnnaimati> copyList = new ArrayList<IT_KyuukzAnnaimati>(pEntity);
        Collections.sort(copyList, new OrderIT_KyuukzAnnaimati(orders));
        return copyList;
    }

    public List<IT_KyuukzAnnaimati> OrderIT_KyuukzAnnaimatiByPkDesc(List<IT_KyuukzAnnaimati> pEntity) {
        List<SortCondition<IT_KyuukzAnnaimati>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KyuukzAnnaimati()).kouteikanriid, SortOrder.DESC));
        List<IT_KyuukzAnnaimati> copyList = new ArrayList<IT_KyuukzAnnaimati>(pEntity);
        Collections.sort(copyList, new OrderIT_KyuukzAnnaimati(orders));
        return copyList;
    }
}
