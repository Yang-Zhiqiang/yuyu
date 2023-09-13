package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_YykIdouUktk;
import yuyu.def.db.meta.QIT_BAK_YykIdouUktk;
import yuyu.def.hozen.comparator.OrderIT_BAK_YykIdouUktk;

public class SortIT_BAK_YykIdouUktk {

    public List<IT_BAK_YykIdouUktk> OrderIT_BAK_YykIdouUktkByPkAsc(List<IT_BAK_YykIdouUktk> pEntity) {
        List<SortCondition<IT_BAK_YykIdouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).kinouId, SortOrder.ASC));
        List<IT_BAK_YykIdouUktk> copyList = new ArrayList<IT_BAK_YykIdouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouUktk(orders));
        return copyList;
    }

    public List<IT_BAK_YykIdouUktk> OrderIT_BAK_YykIdouUktkByPkDesc(List<IT_BAK_YykIdouUktk> pEntity) {
        List<SortCondition<IT_BAK_YykIdouUktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouUktk()).kinouId, SortOrder.DESC));
        List<IT_BAK_YykIdouUktk> copyList = new ArrayList<IT_BAK_YykIdouUktk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouUktk(orders));
        return copyList;
    }

}

