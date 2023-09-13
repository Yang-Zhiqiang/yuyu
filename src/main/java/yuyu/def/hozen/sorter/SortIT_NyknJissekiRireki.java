package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.comparator.OrderIT_NyknJissekiRireki;

public class SortIT_NyknJissekiRireki {

    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRirekiByPkAsc(List<IT_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).jyutoustartym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).renno, SortOrder.ASC));
        List<IT_NyknJissekiRireki> copyList = new ArrayList<IT_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_NyknJissekiRireki(orders));
        return copyList;
    }

    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRirekiByPkDesc(List<IT_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).jyutoustartym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).renno, SortOrder.DESC));
        List<IT_NyknJissekiRireki> copyList = new ArrayList<IT_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_NyknJissekiRireki(orders));
        return copyList;
    }
    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRirekiByJyutoustartymAsc(List<IT_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).jyutoustartym, SortOrder.ASC));
        List<IT_NyknJissekiRireki> copyList = new ArrayList<IT_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_NyknJissekiRireki(orders));
        return copyList;
    }
    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRirekiByRyosyuymdRennoAsc(List<IT_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).ryosyuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).renno, SortOrder.ASC));
        List<IT_NyknJissekiRireki> copyList = new ArrayList<IT_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_NyknJissekiRireki(orders));
        return copyList;
    }



}

