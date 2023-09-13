package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.QIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHasseijiKazeiRireki;

public class SortIT_BAK_KhHasseijiKazeiRireki {

    public List<IT_BAK_KhHasseijiKazeiRireki> OrderIT_BAK_KhHasseijiKazeiRirekiByPkAsc(List<IT_BAK_KhHasseijiKazeiRireki> pEntity) {
        List<SortCondition<IT_BAK_KhHasseijiKazeiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KhHasseijiKazeiRireki> copyList = new ArrayList<IT_BAK_KhHasseijiKazeiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHasseijiKazeiRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KhHasseijiKazeiRireki> OrderIT_BAK_KhHasseijiKazeiRirekiByPkDesc(List<IT_BAK_KhHasseijiKazeiRireki> pEntity) {
        List<SortCondition<IT_BAK_KhHasseijiKazeiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHasseijiKazeiRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KhHasseijiKazeiRireki> copyList = new ArrayList<IT_BAK_KhHasseijiKazeiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHasseijiKazeiRireki(orders));
        return copyList;
    }
}
