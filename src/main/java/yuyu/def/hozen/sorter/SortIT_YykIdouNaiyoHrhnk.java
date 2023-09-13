package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.QIT_YykIdouNaiyoHrhnk;
import yuyu.def.hozen.comparator.OrderIT_YykIdouNaiyoHrhnk;

public class SortIT_YykIdouNaiyoHrhnk {

    public List<IT_YykIdouNaiyoHrhnk> OrderIT_YykIdouNaiyoHrhnkByPkAsc(List<IT_YykIdouNaiyoHrhnk> pEntity) {
        List<SortCondition<IT_YykIdouNaiyoHrhnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).henkousikibetukey, SortOrder.ASC));
        List<IT_YykIdouNaiyoHrhnk> copyList = new ArrayList<IT_YykIdouNaiyoHrhnk>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouNaiyoHrhnk(orders));
        return copyList;
    }

    public List<IT_YykIdouNaiyoHrhnk> OrderIT_YykIdouNaiyoHrhnkByPkDesc(List<IT_YykIdouNaiyoHrhnk> pEntity) {
        List<SortCondition<IT_YykIdouNaiyoHrhnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouNaiyoHrhnk()).henkousikibetukey, SortOrder.DESC));
        List<IT_YykIdouNaiyoHrhnk> copyList = new ArrayList<IT_YykIdouNaiyoHrhnk>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouNaiyoHrhnk(orders));
        return copyList;
    }

}

