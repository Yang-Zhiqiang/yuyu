package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhTtdkRireki;
import yuyu.def.db.meta.QIT_BAK_KhTtdkRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhTtdkRireki;

public class SortIT_BAK_KhTtdkRireki {

    public List<IT_BAK_KhTtdkRireki> OrderIT_BAK_KhTtdkRirekiByPkAsc(List<IT_BAK_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_BAK_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KhTtdkRireki> copyList = new ArrayList<IT_BAK_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTtdkRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KhTtdkRireki> OrderIT_BAK_KhTtdkRirekiByPkDesc(List<IT_BAK_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_BAK_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhTtdkRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KhTtdkRireki> copyList = new ArrayList<IT_BAK_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhTtdkRireki(orders));
        return copyList;
    }

}

