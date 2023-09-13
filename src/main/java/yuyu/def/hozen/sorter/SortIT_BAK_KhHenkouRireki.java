package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenkouRireki;
import yuyu.def.db.meta.QIT_BAK_KhHenkouRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenkouRireki;

public class SortIT_BAK_KhHenkouRireki {

    public List<IT_BAK_KhHenkouRireki> OrderIT_BAK_KhHenkouRirekiByPkAsc(List<IT_BAK_KhHenkouRireki> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).renno3keta, SortOrder.ASC));
        List<IT_BAK_KhHenkouRireki> copyList = new ArrayList<IT_BAK_KhHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenkouRireki> OrderIT_BAK_KhHenkouRirekiByPkDesc(List<IT_BAK_KhHenkouRireki> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouRireki()).renno3keta, SortOrder.DESC));
        List<IT_BAK_KhHenkouRireki> copyList = new ArrayList<IT_BAK_KhHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouRireki(orders));
        return copyList;
    }

}

