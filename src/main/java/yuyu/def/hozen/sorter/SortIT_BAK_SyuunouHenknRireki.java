package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_SyuunouHenknRireki;
import yuyu.def.db.meta.QIT_BAK_SyuunouHenknRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_SyuunouHenknRireki;

public class SortIT_BAK_SyuunouHenknRireki {

    public List<IT_BAK_SyuunouHenknRireki> OrderIT_BAK_SyuunouHenknRirekiByPkAsc(List<IT_BAK_SyuunouHenknRireki> pEntity) {
        List<SortCondition<IT_BAK_SyuunouHenknRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).edano, SortOrder.ASC));
        List<IT_BAK_SyuunouHenknRireki> copyList = new ArrayList<IT_BAK_SyuunouHenknRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyuunouHenknRireki(orders));
        return copyList;
    }

    public List<IT_BAK_SyuunouHenknRireki> OrderIT_BAK_SyuunouHenknRirekiByPkDesc(List<IT_BAK_SyuunouHenknRireki> pEntity) {
        List<SortCondition<IT_BAK_SyuunouHenknRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyuunouHenknRireki()).edano, SortOrder.DESC));
        List<IT_BAK_SyuunouHenknRireki> copyList = new ArrayList<IT_BAK_SyuunouHenknRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyuunouHenknRireki(orders));
        return copyList;
    }

}

