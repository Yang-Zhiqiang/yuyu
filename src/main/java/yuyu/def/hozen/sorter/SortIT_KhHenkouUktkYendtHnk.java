package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;
import yuyu.def.hozen.comparator.OrderIT_KhHenkouUktkYendtHnk;

public class SortIT_KhHenkouUktkYendtHnk {

    public List<IT_KhHenkouUktkYendtHnk> OrderIT_KhHenkouUktkYendtHnkByPkAsc(List<IT_KhHenkouUktkYendtHnk> pEntity) {
        List<SortCondition<IT_KhHenkouUktkYendtHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_KhHenkouUktkYendtHnk> copyList = new ArrayList<IT_KhHenkouUktkYendtHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkYendtHnk(orders));
        return copyList;
    }

    public List<IT_KhHenkouUktkYendtHnk> OrderIT_KhHenkouUktkYendtHnkByPkDesc(List<IT_KhHenkouUktkYendtHnk> pEntity) {
        List<SortCondition<IT_KhHenkouUktkYendtHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkYendtHnk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_KhHenkouUktkYendtHnk> copyList = new ArrayList<IT_KhHenkouUktkYendtHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkYendtHnk(orders));
        return copyList;
    }
}
