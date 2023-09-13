package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.comparator.OrderIT_YykIdouUktk;

public class SortIT_YykIdouUktk {

    public List<IT_YykIdouUktk> OrderIT_YykIdouUktkByPkAsc(List<IT_YykIdouUktk> pEntity) {
        List<SortCondition<IT_YykIdouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).kinouId, SortOrder.ASC));
        List<IT_YykIdouUktk> copyList = new ArrayList<IT_YykIdouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouUktk(orders));
        return copyList;
    }

    public List<IT_YykIdouUktk> OrderIT_YykIdouUktkByPkDesc(List<IT_YykIdouUktk> pEntity) {
        List<SortCondition<IT_YykIdouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouUktk()).kinouId, SortOrder.DESC));
        List<IT_YykIdouUktk> copyList = new ArrayList<IT_YykIdouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouUktk(orders));
        return copyList;
    }

}

