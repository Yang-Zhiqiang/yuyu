package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.db.meta.QIT_CardTourokuMati;
import yuyu.def.hozen.comparator.OrderIT_CardTourokuMati;

public class SortIT_CardTourokuMati {

    public List<IT_CardTourokuMati> OrderIT_CardTourokuMatiByPkAsc(List<IT_CardTourokuMati> pEntity) {
        List<SortCondition<IT_CardTourokuMati>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CardTourokuMati()).kouteikanriid, SortOrder.ASC));
        List<IT_CardTourokuMati> copyList = new ArrayList<IT_CardTourokuMati>(pEntity);
        Collections.sort(copyList, new OrderIT_CardTourokuMati(orders));
        return copyList;
    }

    public List<IT_CardTourokuMati> OrderIT_CardTourokuMatiByPkDesc(List<IT_CardTourokuMati> pEntity) {
        List<SortCondition<IT_CardTourokuMati>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CardTourokuMati()).kouteikanriid, SortOrder.DESC));
        List<IT_CardTourokuMati> copyList = new ArrayList<IT_CardTourokuMati>(pEntity);
        Collections.sort(copyList, new OrderIT_CardTourokuMati(orders));
        return copyList;
    }
}
