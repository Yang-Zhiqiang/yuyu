package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HurikaeYousi;
import yuyu.def.db.meta.QIT_BAK_HurikaeYousi;
import yuyu.def.hozen.comparator.OrderIT_BAK_HurikaeYousi;

public class SortIT_BAK_HurikaeYousi {

    public List<IT_BAK_HurikaeYousi> OrderIT_BAK_HurikaeYousiByPkAsc(List<IT_BAK_HurikaeYousi> pEntity) {
        List<SortCondition<IT_BAK_HurikaeYousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_HurikaeYousi> copyList = new ArrayList<IT_BAK_HurikaeYousi>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HurikaeYousi(orders));
        return copyList;
    }

    public List<IT_BAK_HurikaeYousi> OrderIT_BAK_HurikaeYousiByPkDesc(List<IT_BAK_HurikaeYousi> pEntity) {
        List<SortCondition<IT_BAK_HurikaeYousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HurikaeYousi()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_HurikaeYousi> copyList = new ArrayList<IT_BAK_HurikaeYousi>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HurikaeYousi(orders));
        return copyList;
    }
}
