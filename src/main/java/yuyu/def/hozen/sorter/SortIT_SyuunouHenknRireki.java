package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.meta.QIT_SyuunouHenknRireki;
import yuyu.def.hozen.comparator.OrderIT_SyuunouHenknRireki;

public class SortIT_SyuunouHenknRireki {

    public List<IT_SyuunouHenknRireki> OrderIT_SyuunouHenknRirekiByPkAsc(List<IT_SyuunouHenknRireki> pEntity) {
        List<SortCondition<IT_SyuunouHenknRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).edano, SortOrder.ASC));
        List<IT_SyuunouHenknRireki> copyList = new ArrayList<IT_SyuunouHenknRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SyuunouHenknRireki(orders));
        return copyList;
    }

    public List<IT_SyuunouHenknRireki> OrderIT_SyuunouHenknRirekiByPkDesc(List<IT_SyuunouHenknRireki> pEntity) {
        List<SortCondition<IT_SyuunouHenknRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyuunouHenknRireki()).edano, SortOrder.DESC));
        List<IT_SyuunouHenknRireki> copyList = new ArrayList<IT_SyuunouHenknRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SyuunouHenknRireki(orders));
        return copyList;
    }

}

