package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.hozen.comparator.OrderIT_KhHenkouUktk;

public class SortIT_KhHenkouUktk {

    public List<IT_KhHenkouUktk> OrderIT_KhHenkouUktkByPkAsc(List<IT_KhHenkouUktk> pEntity) {
        List<SortCondition<IT_KhHenkouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_KhHenkouUktk> copyList = new ArrayList<IT_KhHenkouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktk(orders));
        return copyList;
    }

    public List<IT_KhHenkouUktk> OrderIT_KhHenkouUktkByPkDesc(List<IT_KhHenkouUktk> pEntity) {
        List<SortCondition<IT_KhHenkouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_KhHenkouUktk> copyList = new ArrayList<IT_KhHenkouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktk(orders));
        return copyList;
    }
}
