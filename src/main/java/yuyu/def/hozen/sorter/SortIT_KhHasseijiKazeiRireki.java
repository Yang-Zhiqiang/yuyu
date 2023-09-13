package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.QIT_KhHasseijiKazeiRireki;
import yuyu.def.hozen.comparator.OrderIT_KhHasseijiKazeiRireki;

public class SortIT_KhHasseijiKazeiRireki {

    public List<IT_KhHasseijiKazeiRireki> OrderIT_KhHasseijiKazeiRirekiByPkAsc(List<IT_KhHasseijiKazeiRireki> pEntity) {
        List<SortCondition<IT_KhHasseijiKazeiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_KhHasseijiKazeiRireki> copyList = new ArrayList<IT_KhHasseijiKazeiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHasseijiKazeiRireki(orders));
        return copyList;
    }

    public List<IT_KhHasseijiKazeiRireki> OrderIT_KhHasseijiKazeiRirekiByPkDesc(List<IT_KhHasseijiKazeiRireki> pEntity) {
        List<SortCondition<IT_KhHasseijiKazeiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHasseijiKazeiRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KhHasseijiKazeiRireki> copyList = new ArrayList<IT_KhHasseijiKazeiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHasseijiKazeiRireki(orders));
        return copyList;
    }
}
