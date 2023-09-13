package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HengakuUnit;
import yuyu.def.db.meta.QIT_HengakuUnit;
import yuyu.def.hozen.comparator.OrderIT_HengakuUnit;

public class SortIT_HengakuUnit {

    public List<IT_HengakuUnit> OrderIT_HengakuUnitByPkAsc(List<IT_HengakuUnit> pEntity) {
        List<SortCondition<IT_HengakuUnit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).unitfundkbn, SortOrder.ASC));
        List<IT_HengakuUnit> copyList = new ArrayList<IT_HengakuUnit>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuUnit(orders));
        return copyList;
    }

    public List<IT_HengakuUnit> OrderIT_HengakuUnitByPkDesc(List<IT_HengakuUnit> pEntity) {
        List<SortCondition<IT_HengakuUnit>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HengakuUnit()).unitfundkbn, SortOrder.DESC));
        List<IT_HengakuUnit> copyList = new ArrayList<IT_HengakuUnit>(pEntity);
        Collections.sort(copyList, new OrderIT_HengakuUnit(orders));
        return copyList;
    }

}

