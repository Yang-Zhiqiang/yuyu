package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.meta.QIT_HrhnTtdkKan;
import yuyu.def.hozen.comparator.OrderIT_HrhnTtdkKan;

public class SortIT_HrhnTtdkKan {

    public List<IT_HrhnTtdkKan> OrderIT_HrhnTtdkKanByPkAsc(List<IT_HrhnTtdkKan> pEntity) {
        List<SortCondition<IT_HrhnTtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).henkousikibetukey, SortOrder.ASC));
        List<IT_HrhnTtdkKan> copyList = new ArrayList<IT_HrhnTtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_HrhnTtdkKan(orders));
        return copyList;
    }

    public List<IT_HrhnTtdkKan> OrderIT_HrhnTtdkKanByPkDesc(List<IT_HrhnTtdkKan> pEntity) {
        List<SortCondition<IT_HrhnTtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrhnTtdkKan()).henkousikibetukey, SortOrder.DESC));
        List<IT_HrhnTtdkKan> copyList = new ArrayList<IT_HrhnTtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_HrhnTtdkKan(orders));
        return copyList;
    }
}
