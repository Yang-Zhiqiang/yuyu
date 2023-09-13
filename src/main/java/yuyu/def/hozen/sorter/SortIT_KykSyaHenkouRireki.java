package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.meta.QIT_KykSyaHenkouRireki;
import yuyu.def.hozen.comparator.OrderIT_KykSyaHenkouRireki;

public class SortIT_KykSyaHenkouRireki {

    public List<IT_KykSyaHenkouRireki> OrderIT_KykSyaHenkouRirekiByPkAsc(List<IT_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_KykSyaHenkouRireki> copyList = new ArrayList<IT_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyaHenkouRireki(orders));
        return copyList;
    }

    public List<IT_KykSyaHenkouRireki> OrderIT_KykSyaHenkouRirekiByPkDesc(List<IT_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KykSyaHenkouRireki> copyList = new ArrayList<IT_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyaHenkouRireki(orders));
        return copyList;
    }

    public List<IT_KykSyaHenkouRireki> OrderIT_KykSyaHenkouRirekiByHenkouSikibetuKeyDesc(List<IT_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KykSyaHenkouRireki> copyList = new ArrayList<IT_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyaHenkouRireki(orders));
        return copyList;
    }

    public List<IT_KykSyaHenkouRireki> OrderIT_KykSyaHenkouRirekiByKouryokuHasseiymdDesc(List<IT_KykSyaHenkouRireki> pEntity) {
        List<SortCondition<IT_KykSyaHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyaHenkouRireki()).kouryokuhasseiymd, SortOrder.DESC));
        List<IT_KykSyaHenkouRireki> copyList = new ArrayList<IT_KykSyaHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyaHenkouRireki(orders));
        return copyList;
    }
}
