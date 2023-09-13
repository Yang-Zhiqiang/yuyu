package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_SeihowebIdouRireki;
import yuyu.def.db.meta.QIT_BAK_SeihowebIdouRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_SeihowebIdouRireki;

public class SortIT_BAK_SeihowebIdouRireki {

    public List<IT_BAK_SeihowebIdouRireki> OrderIT_BAK_SeihowebIdouRirekiByPkAsc(List<IT_BAK_SeihowebIdouRireki> pEntity) {
        List<SortCondition<IT_BAK_SeihowebIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_SeihowebIdouRireki> copyList = new ArrayList<IT_BAK_SeihowebIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SeihowebIdouRireki(orders));
        return copyList;
    }

    public List<IT_BAK_SeihowebIdouRireki> OrderIT_BAK_SeihowebIdouRirekiByPkDesc(List<IT_BAK_SeihowebIdouRireki> pEntity) {
        List<SortCondition<IT_BAK_SeihowebIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SeihowebIdouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_SeihowebIdouRireki> copyList = new ArrayList<IT_BAK_SeihowebIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SeihowebIdouRireki(orders));
        return copyList;
    }
}
