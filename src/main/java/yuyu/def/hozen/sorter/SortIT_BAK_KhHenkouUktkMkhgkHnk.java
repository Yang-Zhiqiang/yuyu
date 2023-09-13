package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktkMkhgkHnk;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenkouUktkMkhgkHnk;

public class SortIT_BAK_KhHenkouUktkMkhgkHnk {

    public List<IT_BAK_KhHenkouUktkMkhgkHnk> OrderIT_BAK_KhHenkouUktkMkhgkHnkByPkAsc(List<IT_BAK_KhHenkouUktkMkhgkHnk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkMkhgkHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_BAK_KhHenkouUktkMkhgkHnk> copyList = new ArrayList<IT_BAK_KhHenkouUktkMkhgkHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkMkhgkHnk(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenkouUktkMkhgkHnk> OrderIT_BAK_KhHenkouUktkMkhgkHnkByPkDesc(List<IT_BAK_KhHenkouUktkMkhgkHnk> pEntity) {
        List<SortCondition<IT_BAK_KhHenkouUktkMkhgkHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenkouUktkMkhgkHnk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_BAK_KhHenkouUktkMkhgkHnk> copyList = new ArrayList<IT_BAK_KhHenkouUktkMkhgkHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenkouUktkMkhgkHnk(orders));
        return copyList;
    }
}
