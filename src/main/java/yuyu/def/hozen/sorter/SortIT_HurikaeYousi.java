package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HurikaeYousi;
import yuyu.def.db.meta.QIT_HurikaeYousi;
import yuyu.def.hozen.comparator.OrderIT_HurikaeYousi;

public class SortIT_HurikaeYousi {

    public List<IT_HurikaeYousi> OrderIT_HurikaeYousiByPkAsc(List<IT_HurikaeYousi> pEntity) {
        List<SortCondition<IT_HurikaeYousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).henkousikibetukey, SortOrder.ASC));
        List<IT_HurikaeYousi> copyList = new ArrayList<IT_HurikaeYousi>(pEntity);
        Collections.sort(copyList, new OrderIT_HurikaeYousi(orders));
        return copyList;
    }

    public List<IT_HurikaeYousi> OrderIT_HurikaeYousiByPkDesc(List<IT_HurikaeYousi> pEntity) {
        List<SortCondition<IT_HurikaeYousi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HurikaeYousi()).henkousikibetukey, SortOrder.DESC));
        List<IT_HurikaeYousi> copyList = new ArrayList<IT_HurikaeYousi>(pEntity);
        Collections.sort(copyList, new OrderIT_HurikaeYousi(orders));
        return copyList;
    }
}
