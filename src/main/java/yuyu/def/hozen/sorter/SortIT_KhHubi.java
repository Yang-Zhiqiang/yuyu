package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.meta.QIT_KhHubi;
import yuyu.def.hozen.comparator.OrderIT_KhHubi;

public class SortIT_KhHubi {

    public List<IT_KhHubi> OrderIT_KhHubiByPkAsc(List<IT_KhHubi> pEntity) {
        List<SortCondition<IT_KhHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubi()).hubisikibetukey, SortOrder.ASC));
        List<IT_KhHubi> copyList = new ArrayList<IT_KhHubi>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubi(orders));
        return copyList;
    }

    public List<IT_KhHubi> OrderIT_KhHubiByPkDesc(List<IT_KhHubi> pEntity) {
        List<SortCondition<IT_KhHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubi()).hubisikibetukey, SortOrder.DESC));
        List<IT_KhHubi> copyList = new ArrayList<IT_KhHubi>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubi(orders));
        return copyList;
    }


}

