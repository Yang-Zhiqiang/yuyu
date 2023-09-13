package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhHenreikin;
import yuyu.def.db.meta.QIT_BAK_KhHenreikin;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhHenreikin;

public class SortIT_BAK_KhHenreikin {

    public List<IT_BAK_KhHenreikin> OrderIT_BAK_KhHenreikinByPkAsc(List<IT_BAK_KhHenreikin> pEntity) {
        List<SortCondition<IT_BAK_KhHenreikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KhHenreikin> copyList = new ArrayList<IT_BAK_KhHenreikin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenreikin(orders));
        return copyList;
    }

    public List<IT_BAK_KhHenreikin> OrderIT_BAK_KhHenreikinByPkDesc(List<IT_BAK_KhHenreikin> pEntity) {
        List<SortCondition<IT_BAK_KhHenreikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhHenreikin()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KhHenreikin> copyList = new ArrayList<IT_BAK_KhHenreikin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhHenreikin(orders));
        return copyList;
    }
}
