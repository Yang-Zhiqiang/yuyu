package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HrhnTtdkKan;
import yuyu.def.db.meta.QIT_BAK_HrhnTtdkKan;
import yuyu.def.hozen.comparator.OrderIT_BAK_HrhnTtdkKan;

public class SortIT_BAK_HrhnTtdkKan {

    public List<IT_BAK_HrhnTtdkKan> OrderIT_BAK_HrhnTtdkKanByPkAsc(List<IT_BAK_HrhnTtdkKan> pEntity) {
        List<SortCondition<IT_BAK_HrhnTtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_HrhnTtdkKan> copyList = new ArrayList<IT_BAK_HrhnTtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HrhnTtdkKan(orders));
        return copyList;
    }

    public List<IT_BAK_HrhnTtdkKan> OrderIT_BAK_HrhnTtdkKanByPkDesc(List<IT_BAK_HrhnTtdkKan> pEntity) {
        List<SortCondition<IT_BAK_HrhnTtdkKan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HrhnTtdkKan()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_HrhnTtdkKan> copyList = new ArrayList<IT_BAK_HrhnTtdkKan>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HrhnTtdkKan(orders));
        return copyList;
    }
}
