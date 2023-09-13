package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.hozen.comparator.OrderIT_KhTtdkRireki;

public class SortIT_KhTtdkRireki {

    public List<IT_KhTtdkRireki> OrderIT_KhTtdkRirekiByPkAsc(List<IT_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_KhTtdkRireki> copyList = new ArrayList<IT_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkRireki(orders));
        return copyList;
    }

    public List<IT_KhTtdkRireki> OrderIT_KhTtdkRirekiByPkDesc(List<IT_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KhTtdkRireki> copyList = new ArrayList<IT_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkRireki(orders));
        return copyList;
    }
    public List<IT_KhTtdkRireki> OrderIT_KhTtdkRirekiBySyoriYmdDesc(List<IT_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).syoriYmd, SortOrder.DESC));
        List<IT_KhTtdkRireki> copyList = new ArrayList<IT_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkRireki(orders));
        return copyList;
    }

    public List<IT_KhTtdkRireki> OrderIT_KhTtdkRirekiByGyoumuKousinTimeDesc(List<IT_KhTtdkRireki> pEntity) {
        List<SortCondition<IT_KhTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTtdkRireki()).gyoumuKousinTime, SortOrder.DESC));
        List<IT_KhTtdkRireki> copyList = new ArrayList<IT_KhTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTtdkRireki(orders));
        return copyList;
    }

}

