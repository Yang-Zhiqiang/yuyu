package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktk;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenkouUktk;

public class SortIT_BAK_KhHenkouUktk {

    public List<IT_BAK_KhHenkouUktk> OrderIT_BAK_KhHenkouUktkByPkAsc(List<IT_BAK_KhHenkouUktk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_BAK_KhHenkouUktk> copyList = new ArrayList<IT_BAK_KhHenkouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktk(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenkouUktk> OrderIT_BAK_KhHenkouUktkByPkDesc(List<IT_BAK_KhHenkouUktk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_BAK_KhHenkouUktk> copyList = new ArrayList<IT_BAK_KhHenkouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktk(orders));
        return copyList;
    }
}
