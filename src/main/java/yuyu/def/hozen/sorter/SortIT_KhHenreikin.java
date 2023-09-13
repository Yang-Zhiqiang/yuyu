package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.meta.QIT_KhHenreikin;
import yuyu.def.hozen.comparator.OrderIT_KhHenreikin;

public class SortIT_KhHenreikin {

    public List<IT_KhHenreikin> OrderIT_KhHenreikinByPkAsc(List<IT_KhHenreikin> pEntity) {
        List<SortCondition<IT_KhHenreikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).henkousikibetukey, SortOrder.ASC));
        List<IT_KhHenreikin> copyList = new ArrayList<IT_KhHenreikin>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenreikin(orders));
        return copyList;
    }

    public List<IT_KhHenreikin> OrderIT_KhHenreikinByPkDesc(List<IT_KhHenreikin> pEntity) {
        List<SortCondition<IT_KhHenreikin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHenreikin()).henkousikibetukey, SortOrder.DESC));
        List<IT_KhHenreikin> copyList = new ArrayList<IT_KhHenreikin>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHenreikin(orders));
        return copyList;
    }
}
