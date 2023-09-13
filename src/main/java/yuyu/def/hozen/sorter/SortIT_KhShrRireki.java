package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.hozen.comparator.OrderIT_KhShrRireki;

public class SortIT_KhShrRireki {

    public List<IT_KhShrRireki> OrderIT_KhShrRirekiByPkAsc(List<IT_KhShrRireki> pEntity) {
        List<SortCondition<IT_KhShrRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_KhShrRireki> copyList = new ArrayList<IT_KhShrRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhShrRireki(orders));
        return copyList;
    }

    public List<IT_KhShrRireki> OrderIT_KhShrRirekiByPkDesc(List<IT_KhShrRireki> pEntity) {
        List<SortCondition<IT_KhShrRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KhShrRireki> copyList = new ArrayList<IT_KhShrRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhShrRireki(orders));
        return copyList;
    }

}

