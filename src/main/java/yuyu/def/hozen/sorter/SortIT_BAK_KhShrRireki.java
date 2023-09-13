package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhShrRireki;
import yuyu.def.db.meta.QIT_BAK_KhShrRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhShrRireki;

public class SortIT_BAK_KhShrRireki {

    public List<IT_BAK_KhShrRireki> OrderIT_BAK_KhShrRirekiByPkAsc(List<IT_BAK_KhShrRireki> pEntity) {
        List<SortCondition<IT_BAK_KhShrRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KhShrRireki> copyList = new ArrayList<IT_BAK_KhShrRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhShrRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KhShrRireki> OrderIT_BAK_KhShrRirekiByPkDesc(List<IT_BAK_KhShrRireki> pEntity) {
        List<SortCondition<IT_BAK_KhShrRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhShrRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KhShrRireki> copyList = new ArrayList<IT_BAK_KhShrRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhShrRireki(orders));
        return copyList;
    }

}

