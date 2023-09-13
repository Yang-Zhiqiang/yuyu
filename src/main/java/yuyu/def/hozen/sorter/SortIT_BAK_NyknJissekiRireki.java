package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_BAK_NyknJissekiRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_NyknJissekiRireki;

public class SortIT_BAK_NyknJissekiRireki {

    public List<IT_BAK_NyknJissekiRireki> OrderIT_BAK_NyknJissekiRirekiByPkAsc(List<IT_BAK_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_BAK_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).jyutoustartym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).renno, SortOrder.ASC));
        List<IT_BAK_NyknJissekiRireki> copyList = new ArrayList<IT_BAK_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_NyknJissekiRireki(orders));
        return copyList;
    }

    public List<IT_BAK_NyknJissekiRireki> OrderIT_BAK_NyknJissekiRirekiByPkDesc(List<IT_BAK_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_BAK_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).jyutoustartym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_NyknJissekiRireki()).renno, SortOrder.DESC));
        List<IT_BAK_NyknJissekiRireki> copyList = new ArrayList<IT_BAK_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_NyknJissekiRireki(orders));
        return copyList;
    }

}

