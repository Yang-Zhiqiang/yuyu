package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HengakuUnitRireki;
import yuyu.def.db.meta.QIT_BAK_HengakuUnitRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_HengakuUnitRireki;

public class SortIT_BAK_HengakuUnitRireki {

    public List<IT_BAK_HengakuUnitRireki> OrderIT_BAK_HengakuUnitRirekiByPkAsc(List<IT_BAK_HengakuUnitRireki> pEntity) {
        List<SortCondition<IT_BAK_HengakuUnitRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_HengakuUnitRireki> copyList = new ArrayList<IT_BAK_HengakuUnitRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuUnitRireki(orders));
        return copyList;
    }

    public List<IT_BAK_HengakuUnitRireki> OrderIT_BAK_HengakuUnitRirekiByPkDesc(List<IT_BAK_HengakuUnitRireki> pEntity) {
        List<SortCondition<IT_BAK_HengakuUnitRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnitRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_HengakuUnitRireki> copyList = new ArrayList<IT_BAK_HengakuUnitRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuUnitRireki(orders));
        return copyList;
    }

}

