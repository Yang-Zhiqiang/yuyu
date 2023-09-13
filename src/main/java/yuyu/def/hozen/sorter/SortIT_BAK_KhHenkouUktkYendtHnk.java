package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktkYendtHnk;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenkouUktkYendtHnk;

public class SortIT_BAK_KhHenkouUktkYendtHnk {

    public List<IT_BAK_KhHenkouUktkYendtHnk> OrderIT_BAK_KhHenkouUktkYendtHnkByPkAsc(List<IT_BAK_KhHenkouUktkYendtHnk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkYendtHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_BAK_KhHenkouUktkYendtHnk> copyList = new ArrayList<IT_BAK_KhHenkouUktkYendtHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkYendtHnk(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenkouUktkYendtHnk> OrderIT_BAK_KhHenkouUktkYendtHnkByPkDesc(List<IT_BAK_KhHenkouUktkYendtHnk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkYendtHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkYendtHnk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_BAK_KhHenkouUktkYendtHnk> copyList = new ArrayList<IT_BAK_KhHenkouUktkYendtHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkYendtHnk(orders));
        return copyList;
    }
}
