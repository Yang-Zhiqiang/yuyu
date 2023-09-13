package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import yuyu.def.db.meta.QIT_HengakuUnitRireki;
import yuyu.def.hozen.comparator.OrderIT_HengakuUnitRireki;

public class SortIT_HengakuUnitRireki {

    public List<IT_HengakuUnitRireki> OrderIT_HengakuUnitRirekiByPkAsc(List<IT_HengakuUnitRireki> pEntity) {
        List<SortCondition<IT_HengakuUnitRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).unitfundkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_HengakuUnitRireki> copyList = new ArrayList<IT_HengakuUnitRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuUnitRireki(orders));
        return copyList;
    }

    public List<IT_HengakuUnitRireki> OrderIT_HengakuUnitRirekiByPkDesc(List<IT_HengakuUnitRireki> pEntity) {
        List<SortCondition<IT_HengakuUnitRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).unitfundkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuUnitRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_HengakuUnitRireki> copyList = new ArrayList<IT_HengakuUnitRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuUnitRireki(orders));
        return copyList;
    }

}

