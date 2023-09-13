package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.db.meta.QIT_SeihowebIdouRireki;
import yuyu.def.hozen.comparator.OrderIT_SeihowebIdouRireki;

public class SortIT_SeihowebIdouRireki {

    public List<IT_SeihowebIdouRireki> OrderIT_SeihowebIdouRirekiByPkAsc(List<IT_SeihowebIdouRireki> pEntity) {
        List<SortCondition<IT_SeihowebIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_SeihowebIdouRireki> copyList = new ArrayList<IT_SeihowebIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SeihowebIdouRireki(orders));
        return copyList;
    }

    public List<IT_SeihowebIdouRireki> OrderIT_SeihowebIdouRirekiByPkDesc(List<IT_SeihowebIdouRireki> pEntity) {
        List<SortCondition<IT_SeihowebIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebIdouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_SeihowebIdouRireki> copyList = new ArrayList<IT_SeihowebIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SeihowebIdouRireki(orders));
        return copyList;
    }
}
