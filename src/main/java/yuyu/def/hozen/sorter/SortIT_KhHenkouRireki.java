package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.hozen.comparator.OrderIT_KhHenkouRireki;

public class SortIT_KhHenkouRireki {

    public List<IT_KhHenkouRireki> OrderIT_KhHenkouRirekiByPkAsc(List<IT_KhHenkouRireki> pEntity) {
        List<SortCondition<IT_KhHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).renno3keta, SortOrder.ASC));
        List<IT_KhHenkouRireki> copyList = new ArrayList<IT_KhHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouRireki(orders));
        return copyList;
    }

    public List<IT_KhHenkouRireki> OrderIT_KhHenkouRirekiByPkDesc(List<IT_KhHenkouRireki> pEntity) {
        List<SortCondition<IT_KhHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouRireki()).renno3keta, SortOrder.DESC));
        List<IT_KhHenkouRireki> copyList = new ArrayList<IT_KhHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouRireki(orders));
        return copyList;
    }

}

