package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.QIT_BAK_YykIdouNaiyoHrhnk;
import yuyu.def.hozen.comparator.OrderIT_BAK_YykIdouNaiyoHrhnk;

public class SortIT_BAK_YykIdouNaiyoHrhnk {

    public List<IT_BAK_YykIdouNaiyoHrhnk> OrderIT_BAK_YykIdouNaiyoHrhnkByPkAsc(List<IT_BAK_YykIdouNaiyoHrhnk> pEntity) {
        List<SortCondition<IT_BAK_YykIdouNaiyoHrhnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_YykIdouNaiyoHrhnk> copyList = new ArrayList<IT_BAK_YykIdouNaiyoHrhnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouNaiyoHrhnk(orders));
        return copyList;
    }

    public List<IT_BAK_YykIdouNaiyoHrhnk> OrderIT_BAK_YykIdouNaiyoHrhnkByPkDesc(List<IT_BAK_YykIdouNaiyoHrhnk> pEntity) {
        List<SortCondition<IT_BAK_YykIdouNaiyoHrhnk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouNaiyoHrhnk()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_YykIdouNaiyoHrhnk> copyList = new ArrayList<IT_BAK_YykIdouNaiyoHrhnk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouNaiyoHrhnk(orders));
        return copyList;
    }

}

