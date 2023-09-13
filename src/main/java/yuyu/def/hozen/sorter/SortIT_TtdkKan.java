package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.meta.QIT_TtdkKan;
import yuyu.def.hozen.comparator.OrderIT_TtdkKan;

public class SortIT_TtdkKan {

    public List<IT_TtdkKan> OrderIT_TtdkKanByPkAsc(List<IT_TtdkKan> pEntity) {
        List<SortCondition<IT_TtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TtdkKan()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TtdkKan()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TtdkKan()).henkousikibetukey, SortOrder.ASC));
        List<IT_TtdkKan> copyList = new ArrayList<IT_TtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_TtdkKan(orders));
        return copyList;
    }

    public List<IT_TtdkKan> OrderIT_TtdkKanByPkDesc(List<IT_TtdkKan> pEntity) {
        List<SortCondition<IT_TtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TtdkKan()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TtdkKan()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TtdkKan()).henkousikibetukey, SortOrder.DESC));
        List<IT_TtdkKan> copyList = new ArrayList<IT_TtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_TtdkKan(orders));
        return copyList;
    }

}

