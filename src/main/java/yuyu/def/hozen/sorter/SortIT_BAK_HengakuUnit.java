package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HengakuUnit;
import yuyu.def.db.meta.QIT_BAK_HengakuUnit;
import yuyu.def.hozen.comparator.OrderIT_BAK_HengakuUnit;

public class SortIT_BAK_HengakuUnit {

    public List<IT_BAK_HengakuUnit> OrderIT_BAK_HengakuUnitByPkAsc(List<IT_BAK_HengakuUnit> pEntity) {
        List<SortCondition<IT_BAK_HengakuUnit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).unitfundkbn, SortOrder.ASC));
        List<IT_BAK_HengakuUnit> copyList = new ArrayList<IT_BAK_HengakuUnit>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuUnit(orders));
        return copyList;
    }

    public List<IT_BAK_HengakuUnit> OrderIT_BAK_HengakuUnitByPkDesc(List<IT_BAK_HengakuUnit> pEntity) {
        List<SortCondition<IT_BAK_HengakuUnit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HengakuUnit()).unitfundkbn, SortOrder.DESC));
        List<IT_BAK_HengakuUnit> copyList = new ArrayList<IT_BAK_HengakuUnit>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HengakuUnit(orders));
        return copyList;
    }

}

