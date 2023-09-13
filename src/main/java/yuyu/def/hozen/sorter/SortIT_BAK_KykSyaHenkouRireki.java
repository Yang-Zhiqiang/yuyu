package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykSyaHenkouRireki;
import yuyu.def.db.meta.QIT_BAK_KykSyaHenkouRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykSyaHenkouRireki;

public class SortIT_BAK_KykSyaHenkouRireki {

    public List<IT_BAK_KykSyaHenkouRireki> OrderIT_BAK_KykSyaHenkouRirekiByPkAsc(List<IT_BAK_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_BAK_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KykSyaHenkouRireki> copyList = new ArrayList<IT_BAK_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyaHenkouRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KykSyaHenkouRireki> OrderIT_BAK_KykSyaHenkouRirekiByPkDesc(List<IT_BAK_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_BAK_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyaHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KykSyaHenkouRireki> copyList = new ArrayList<IT_BAK_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyaHenkouRireki(orders));
        return copyList;
    }
}
