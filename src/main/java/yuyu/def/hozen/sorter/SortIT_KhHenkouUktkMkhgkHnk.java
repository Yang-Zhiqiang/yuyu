package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkMkhgkHnk;
import yuyu.def.hozen.comparator.OrderIT_KhHenkouUktkMkhgkHnk;

public class SortIT_KhHenkouUktkMkhgkHnk {

    public List<IT_KhHenkouUktkMkhgkHnk> OrderIT_KhHenkouUktkMkhgkHnkByPkAsc(List<IT_KhHenkouUktkMkhgkHnk> pEntity) {
        List<SortCondition<IT_KhHenkouUktkMkhgkHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<IT_KhHenkouUktkMkhgkHnk> copyList = new ArrayList<IT_KhHenkouUktkMkhgkHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkMkhgkHnk(orders));
        return copyList;
    }

    public List<IT_KhHenkouUktkMkhgkHnk> OrderIT_KhHenkouUktkMkhgkHnkByPkDesc(List<IT_KhHenkouUktkMkhgkHnk> pEntity) {
        List<SortCondition<IT_KhHenkouUktkMkhgkHnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenkouUktkMkhgkHnk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<IT_KhHenkouUktkMkhgkHnk> copyList = new ArrayList<IT_KhHenkouUktkMkhgkHnk>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenkouUktkMkhgkHnk(orders));
        return copyList;
    }
}
